# JavaCvPlayer 整合與 Desktop VLC 替換技術方案總結

本文件紀錄將 `ComposeMultiplatformMediaPlayer` 桌面端 (JVM) 底層引擎由 VLC 替換為 **JavaCvPlayer (基於 JavaCV/FFmpeg)** 的完整思路與實作細節。

---

## 1. 核心思路：影子模組策略 (Shadowing Strategy)

為了在不破壞原始 UI 邏輯與跨平台符號引用的前提下替換底層引擎，我們採用了「影子模組」技術：

1.  **建立本地代碼庫**：在 `local_library/media_player` 建立一個影子模組。
2.  **包名對齊，GroupID 隔離**：
    *   **Package Name**：維持與官方庫一致的 `chaintech.videoplayer`。
    *   **Group ID**：設為自定義的 `idv.neo.shadow`，防止與遠端庫在 Gradle 解析時發生衝突。
3.  **編譯期遮蔽**：在 JVM 端編譯時，讓 Classpath 優先指向本地模組，從而將原本呼叫 VLC 的 `expect fun CMPPlayer` 重新導向至 JavaCV 實作。

## 2. 架構映射與模組連結

我們透過 `settings.gradle.kts` 的 `include` 機制，直接連結了成熟的 `JavaCvPlayer` 核心組件：

*   **`:common-lite`**：提供 `androidx.media3.common` 兼容介面。
*   **`:core`**：封裝 JavaCV (FFmpeg) 的解碼與播放時鐘邏輯。
*   **`:core-video-skia`**：利用 Skia 繪圖引擎達成高性能影像渲染。
*   **`:ui-compose-javacv`**：提供 Compose 專用的 `VideoPlayerCanvas` 組件。

## 3. 關鍵修正與優化

### A. 依賴分流 (Dependency Splitting)
在 `composeApp/build.gradle.kts` 中，針對不同平台實施依賴隔離：
*   **Android/iOS/Web**：繼續使用遠端官方庫，維持生產環境穩定。
*   **JVM (Desktop)**：透過 `api(project(":media_player"))` 強制切換為本地 JavaCV 核心。
*   **編譯兼容**：在 `commonMain` 使用 `compileOnly` 引用遠端庫，解決 UI 代碼在撰寫時的符號引用問題。

### B. JAR 資源提取機制 (Resource Extraction)
**問題**：FFmpeg (Native Library) 無法讀取打包在 JAR 檔案內部的影片資源（如 `2.mp4`）。
**解法**：修正 `util.jvm.kt` 中的 `getLocalFilePathFor` 實作：
1.  透過 `getResourceAsStream` 抓取資源流。
2.  將其寫入系統臨時目錄 (`createTempFile`)。
3.  返回真實的檔案系統路徑給播放器。
4.  設定 `deleteOnExit()` 確保環境乾淨。

### C. 渲染路徑優化 (Skia Rendering)
*   **廢棄 VLC Callback**：移除原本複雜且易報錯的 `RenderCallbackAdapter`。
*   **Skia 直接渲染**：在 `CMPlayer.jvm.kt` 中使用 `VideoPlayerCanvas` 並指定 `RenderMode.SKIA`。影像影格直接繪製在 Compose 的繪圖表面上，效能極佳且支援 Compose 的 UI 變換（如縮放與裁切）。

## 4. 檔案變更清單
*   `settings.gradle.kts`: 連結本地庫模組。
*   `composeApp/build.gradle.kts`: 實作多平台依賴分流。
*   `local_library/media_player/build.gradle.kts`: 配置 JavaCV/FFmpeg 依賴與平台自動偵測。
*   `CMPlayer.jvm.kt` & `CMPAudioPlayer.jvm.kt`: 實作 JavaCvPlayer 橋接，統一影音引擎。
*   `util.jvm.kt`: 實作影音資源臨時提取邏輯（解決 JAR 內資源讀取限制）。

---
**成果**：Desktop (JVM) 版本現在具備「開箱即播」能力，不再要求用戶預先安裝 VLC。
