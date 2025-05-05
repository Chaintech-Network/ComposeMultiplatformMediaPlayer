# 1.0.40 [2025-05-01]
### Added
- 🖥️ **Desktop Fullscreen Support:** Added support for fullscreen mode on desktop. You can manually toggle between fullscreen and floating window modes using control buttons.

## 🖼️ Cross-Platform Drawable Migration Guide
⚠️ **Background**
Previously, this library used `org.jetbrains.compose.resources.DrawableResource`, which is only available in Compose Multiplatform.
However, this causes compatibility issues when used in Android-only Compose projects, which don’t support `DrawableResource`.

To solve this, we’ve introduced a new platform-agnostic abstraction: `PlatformDrawable`.

✅ **Use per platform:**

**Android:** AndroidResourceDrawable(R.drawable.icon)

**Compose Multiplatform:** ComposeResourceDrawable(Res.drawable.icon)


## 📋 Setup Guide for Fullscreen Support in Desktop
To enable fullscreen and window placement control from the library, you need to provide your app's WindowState using CompositionLocalProvider.

**For example:**
```kotlin
fun main() = application {
    val windowState = rememberWindowState(width = 900.dp, height = 700.dp)
    CompositionLocalProvider(LocalWindowState provides windowState) {
        Window(
            title = "MediaPlayer",
            state = windowState,
            onCloseRequest = ::exitApplication,
        ) {
            MainView()
        }
    }
}
```


# 1.0.39 [2025-04-25]

### Customization Options
| Property                 | Description                                                                       |
|--------------------------|-----------------------------------------------------------------------------------|
| enableFullEdgeToEdge     | Uses immersive full-screen mode that extends content into system and cutout areas |
| enableBackButton         | Shows a back button at the top-left corner when true                              |
| backIconResource         | Custom icon for the back button (`DrawableResource`)                              |
| backActionCallback       | Callback triggered when back button is tapped                                     |



# 1.0.38 [2025-04-11] 
### Added
- 💧 **Dynamic Watermark Overlay:** Display a customizable watermark that appears inside the video player, moves randomly within the player bounds, and supports configurable visibility timing with `stayDelay` and `hideDelay` options. Supports composable or image-based watermark content.
- 🔖 **Chapter Support on SeekBar:** Chapters are now visually integrated into the SeekBar track, allowing users to see content sections at a glance. Active chapter title is dynamically displayed during playback or when scrubbing through the video.

### Customization Options
| Property                           | Description                                                                                            |
|------------------------------------|--------------------------------------------------------------------------------------------------------|
| watermarkConfig                    | Allows adding a dynamic watermark that moves within video bounds with customizable content and timing. |
| chapters                           | Shows chapter points on the SeekBar with titles.                                                       |
| seekBarBottomPaddingInFullScreen   | Configure the bottom padding for the seek bar control at the time of fullscreen.                       |




# 1.0.37  [2025-04-07]
### Added
- 🎚️ **Quality Selection Overlay**: Manually select video quality if supported or let the player auto-adjust.
- 🏷️ **Caption Selection**: Choose from available subtitles or disable them.
- 🔊 **Audio Track Selection**: Switch between different audio tracks if supported.

### Customization Options
| Property                | Description                                                                                 |
|-------------------------|---------------------------------------------------------------------------------------------|
| seekBarThumbRadius      | Adjusts the size of the seek bar thumb.                                                     |
| seekBarTrackHeight      | Adjusts the height of the seek bar track.                                                   |
| showVideoQualityOptions | Lets users select from available video resolutions.                                         |                                                                                        |
| showAudioTracksOptions  | Lets users switch between available audio tracks.                                           | 
| showSubTitlesOptions    | Lets users choose from available subtitles.                                                 |



# 1.0.36 [2025-03-26]
### Added
- 🔍 **Configurable Zoom:** `isZoomEnabled` has been moved from `MediaPlayerHost` to `VideoPlayerConfig` for better customization.
- 🔊 **Volume Control with Gesture:** Adjust volume by dragging vertically on the right side of the player. Enable/disable with `isGestureVolumeControlEnabled`.
- 📏 **Retrieve Media Duration:** Easily fetch the duration of a media file using the `RetrieveMediaDuration` function.
- 🎥 **Reels Player Enhancements:** Retrieve the current reel index while playing multiple videos in reels format.

### Customization Options
| Property                                    | Description                                                                           |
|---------------------------------------------|---------------------------------------------------------------------------------------|
| isZoomEnabled                               | Enables or disables zoom functionality. Defaults to true.                             |
| isGestureVolumeControlEnabled               | Allows to control volume level by using vertical drag gesture on right side of player |



# 1.0.35 [2025-03-20]
### Added
- 🔄 **Seamless Resume:** Videos now automatically resume from the last saved position, ensuring a smooth viewing experience.
- 🎯 **Smart Saving Logic:** Playback position is saved intelligently based on video length, optimizing for movies, short clips, and everything in between.
- ▶️ **Auto-Play Next Reel:** Automatically plays the next reel when the current one ends for a continuous viewing experience.

### Customization Options
| Property                             | Description                                                                                                      |
|--------------------------------------|------------------------------------------------------------------------------------------------------------------|
| controlClickAnimationDuration        | Duration (in milliseconds) of the click animation applied to a button or control when the user interacts with it |
| backdropAlpha                        | Controls the transparency of the backdrop beneath the media controls.                                            |
| autoPlayNextReel                     | Automatically plays the next reel when the current one ends.                                                     |
| enableResumePlayback                 | Resume from last saved position.                                                                                 |



# 1.0.33 [2025-02-28]
### Added
- 🔐 **Clear Key Encryption (Android):** Support for encrypted media playback using clear key on Android.
- 🧾 **Custom Headers:** Ability to pass custom headers with media URLs.
- ⏩ **Precise Seeking:** Support for seeking to fractional (floating-point) values in media.
- 🖥️ **Fullscreen Change Event:** New `FullScreenChange` event for fullscreen state tracking.



# 1.0.31 [2025-02-17]
### Added
- 🚀 **MediaPlayerHost Integration:** `AudioPlayerComposable` now integrates with `MediaPlayerHost`, decoupling playback logic from the built-in UI. Customize or replace the default UI while maintaining smooth audio playback.
- 📝 **Standalone Audio Player:** The audio player is now fully independent, offering more flexibility for various use cases.

### Customization Options
| Property                          | Description                                                                          |
|-----------------------------------|--------------------------------------------------------------------------------------|
| showControl                       | Toggle to show or hide the AudioPlayer UI for a customizable playback experience.    |




# 1.0.30 [2025-02-03]
### Added
- 🔥 **VideoPlayerHost Integration:** `VideoPlayerComposable` now works with the new `VideoPlayerHost` composable, separating video player logic from the inbuilt UI. Gain full control to customize or replace the default UI.
- 📝 **Updated Configurations:** Simplified `VideoPlayerConfig` by removing unnecessary settings. Refer to the customization section for the updated configuration options.

### Customization Options
| Property                                  | Description                                                                                  |
|-------------------------------------------|----------------------------------------------------------------------------------------------|
| isLiveStream                              | A boolean property that indicates whether the currently playing video is a live stream.      |




# 1.0.29 [2024-01-10]
### Added
- 🎞️ **Video Preview:** Display animated video previews for a more engaging experience.



# 1.0.26 [2024-10-30]
### Added
- 🖥️ **YouTube Support for Desktop:** Seamlessly enjoy YouTube playback on desktop platforms!
- 📲 **Video Caching:** Enhanced playback experience with optimized video caching on Android devices!
