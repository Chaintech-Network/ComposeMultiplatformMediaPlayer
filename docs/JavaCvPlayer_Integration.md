# JavaCvPlayer Integration Documentation

## Overview
This document describes the integration of the `JavaCvPlayer` (FFmpeg/JavaCV-based) media player into the Desktop (JVM) target of the `ComposeMultiplatformMediaPlayer` project. This replaces the previous reliance on a system-installed VLC player.

## Motivation
The original `compose-multiplatform-media-player` library required VLC to be installed on the host system for Desktop playback. This created environment setup difficulties for users. `JavaCvPlayer` bundles FFmpeg via JavaCV二進制檔案, providing a portable, consistent, and high-performance experience.

## Key Changes

### 1. Media Source Update
- **File**: `[MockData.kt](file:///Users/neo.chang/Documents/AndroidStudioProjects/ComposeMultiplatformMediaPlayer/composeApp/src/commonMain/kotlin/org/chaintech/app/model/MockData.kt)`
- **Change**: Updated testing sources across all platforms to the HLS stream: `https://video-ws-hls-aws.langhongtw.com/live/4282279Y/playlist.m3u8`.

### 2. JVM Video Player Implementation
- **File**: `[UniversalVideoPlayer.jvm.kt](file:///Users/neo.chang/Documents/AndroidStudioProjects/ComposeMultiplatformMediaPlayer/composeApp/src/jvmMain/kotlin/org/chaintech/app/ui/components/UniversalVideoPlayer.jvm.kt)`
- **Implementation Highlights**:
    - **Core**: Uses `JvmJavaCvPlayer` from the `:JavaCvPlayer:core` module.
    - **Rendering**: Explicitly configured to use `SkiaVideoSink` for zero-copy style rendering directly onto the Skia Canvas.
    - **Audio**: Uses `JvmAudioSink` for JVM-native audio output.
    - **Lifecycle Management**:
        - `remember`: Persists the player instance during recompositions.
        - `DisposableEffect(Unit)`: Guarantees `player.release()` is called only when the component leaves the composition, preventing resource leaks.
        - `LaunchedEffect(url)`: Listens for URL changes to trigger `setMediaItem`, `prepare`, and `play` without resetting the player instance.

### 3. Build & Dependency Structure
- **Included Build**: The `JavaCvPlayer` project is integrated as an included build in `settings.gradle.kts`.
- **Media3 Compatibility**: Leverages the `common-lite` module to provide a KMP-friendly version of `androidx.media3.common` (MediaItem, Player interface, etc.), allowing the Desktop implementation to follow the same API patterns as Android's ExoPlayer.

## Verification
- **Compilation**: Successfully verified using `:composeApp:compileKotlinJvm`.
- **Compatibility**: The UI components correctly interface with the `JavaCvPlayer` core through the `ui-compose-javacv` module.
