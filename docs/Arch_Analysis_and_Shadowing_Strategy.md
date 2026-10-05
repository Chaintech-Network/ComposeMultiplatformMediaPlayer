# 架構分析與 Shadowing 替換策略文件

本文件詳細紀錄了對 `ComposeMultiplatformMediaPlayer` 庫的架構分析，以及如何透過 "Shadowing" 技術將其 JVM 底層引擎由 VLC 替換為 `JavaCvPlayer` 的實作方案。

## 1. 庫架構深度分析

透過對 `sources.jar` 的反編譯與原始碼分析，該庫採用了典型的「UI 與引擎分離」設計：

### A. MediaPlayerHost (CommonMain - 狀態持有者)
*   **角色**：播放器的「大腦」。
*   **實作**：一個純粹的 Kotlin 類別，使用 Compose 的 `mutableStateOf` 維護狀態（如 `url`, `isPaused`, `currentTime`）。
*   **跨平台特性**：它完全位於 `commonMain`，不需要 `expect/actual`。它透過監聽 UI 操作來改變狀態，並由底層組件觀察這些狀態。

### B. CMPPlayer (Expect/Actual - 引擎橋接器)
*   **角色**：這是真正的跨平台對接點。
*   **Android 實現**：在 `androidMain` 中透過 `CMPPlayer.android.kt` 調用 **Media3/ExoPlayer**。它將 `ExoPlayer` 嵌入 `AndroidView`，並將播放進度回傳給 `MediaPlayerHost`。
*   **JVM 實現 (原始)**：在 `jvmMain` 中透過 `CMPPlayer.jvm.kt` 調用 **VLC (vlcj)**。
*   **JVM 實現 (目標)**：改為調用 **JavaCvPlayer (FFmpeg)**。

### C. DesktopVideoPlayer (CommonMain - UI 外殼)
*   **疑點澄清**：為何檔名帶有 "Desktop" 卻放在 `commonMain`？
*   **分析**：它其實是一個專為桌面端大螢幕設計的 **Compose UI 佈局**（包含音量條、桌面版控制面板）。它在內部呼叫了 `expect fun CMPPlayer`。這證明了該庫試圖在 `commonMain` 中定義多套 UI 佈局（如手機版 vs 桌面版），但底層引擎切換依然發生在 `CMPPlayer`。

---

## 2. "Shadowing" 替換策略

為了在不破毀官方庫原始結構的前提下進行 PR 預演，我們採取的策略如下：

### 核心目標
在執行 JVM 版本時，讓 Classpath 優先指向我們本地開發的 `CMPPlayer` 實作，從而「遮蔽」掉官方庫原本的 VLC 實作。

### 具體實作方案

1.  **建立本地代理模組 (`:media-player-local`)**：
    *   **Group ID**：設為與官方不同的 ID（如 `idv.neo.shadow`），防止 Gradle 的 Dependency Resolution 發生強制替換。
    *   **Package Name**：必須與官方完全一致 (`chaintech.videoplayer`)，以達成 Shadowing 效果。

2.  **依賴分離 (Dependency Decoupling)**：
    *   **`commonMain`**：使用 `compileOnly` 依賴本地代理模組。這確保了編譯期能找到 `MediaPlayerHost` 等符號，但 Runtime 不會打包進去（避免與 Android 端的遠端庫衝突產生 Duplicate Classes）。
    *   **`jvmMain`**：使用 `implementation` 依賴本地代理模組，並在其中完成 `JavaCvPlayer` 的對接。
    *   **Android/iOS**：維持依賴遠端官方庫，確保生產環境的穩定性。

3.  **功能完善路徑**：
    *   **雙向同步**：在本地 `CMPPlayer.jvm.kt` 中，建立 `Player.Listener`。
    *   **進度回傳**：將 `JavaCvPlayer` 的當前秒數回傳給 `MediaPlayerHost` 的 `updateCurrentTime` Lambda。
    *   **錯誤處理**：捕捉 FFmpeg 異常並封裝為 `MediaPlayerError`。

## 3. PR 改動範圍預測 (核心文件)

若要正式提交 PR 給 `Chaintech-Network`，改動將集中在：
*   `libraries/media-player/src/jvmMain/kotlin/chaintech/videoplayer/util/CMPlayer.jvm.kt`
*   移除 `RenderCallbackAdapter.kt` 等 VLC 特有類別。
*   更新 `build.gradle.kts` 的 JVM 依賴項。

---
**文件日期**：2025年10月
**狀態**：架構分析完成，Shadowing 方案驗證中。
