# Compose Multiplatform Media Player
[![Maven Central](https://img.shields.io/maven-central/v/network.chaintech/compose-multiplatform-media-player.svg)](https://central.sonatype.com/artifact/network.chaintech/compose-multiplatform-media-player)
[![Kotlin](https://img.shields.io/badge/kotlin-v2.1.0-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.7.3-blue)](https://github.com/JetBrains/compose-multiplatform)
[![License](https://img.shields.io/github/license/Chaintech-Network/ComposeMultiplatformMediaPlayer)](http://www.apache.org/licenses/LICENSE-2.0)

![badge-android](http://img.shields.io/badge/platform-android-3DDC84.svg?style=flat)
![badge-ios](http://img.shields.io/badge/platform-ios-FF375F.svg?style=flat)
![badge-desktop](http://img.shields.io/badge/platform-desktop-FF9500.svg?style=flat)

Compose Multiplatform Media Player is a powerful media player library designed for Compose Multiplatform projects. It enables seamless video player, reels viewing, audio playing, YouTube video integration, video preview thumbnails and HLS m3u8 support on iOS, Android, and Desktop platforms. The library offers extensive customization options for various controls, making it flexible for different types of media applications.

![Blog-banner-02 5](./assets/git_banner4.jpg)

## 🎉 What's New in Version 1.0.30
* 🔥 **VideoPlayerHost Integration:** The `VideoPlayerComposable` now works with the new `VideoPlayerHost` composable, separating video player logic from inbuilt UI. This gives you more control over playback and allows you to fully customize or replace the default UI. 
* 📝 **Updated Configurations:** Simplified the VideoPlayerConfig by removing unnecessary settings. Refer to the customization section for updated configuration properties.

## ✨ Features
**Cross-Platform Compatibility:** Works seamlessly on iOS, Android, and Desktop platforms within Compose Multiplatform projects.

**Video Player:** Effortlessly play videos in your app with high performance and reliability.

**HLS m3u8 Playback:** Stream live and on-demand content using the HLS .m3u8 format.

**YouTube Player:** Integrate YouTube videos directly into your app, with full control over playback and video state management.

**Reel Viewing:** Enjoy reel viewing with support for horizontal and vertical scrolling.

**Audio Player:** Enjoy high-quality audio playback with customizable controls.

**Video Preview:** Display animated video previews for a more engaging experience.

**Customizable Controls:** Enable/disable pause/resume functionality and adjust the appearance and visibility of the seek bar, along with various control icons and colors.

![media-player-animation-updated2](./assets/player_example1.gif)

![media-player-animation-updated2](./assets/desktop_player.gif)

## 📦 Installation

Add the following dependency to your `build.gradle.kts` file:

```kotlin
commonMain.dependencies {
    implementation("network.chaintech:compose-multiplatform-media-player:1.0.30")
}
```
💡 **Note:** For desktop video player, ensure VLC Player is installed, and for desktop YouTube support, Java must be installed on your system.

## 🎬 Usage

## VideoPlayerHost Class
### Constructor Parameters
* **url (String):** The URL of the video to be played.
* **isPaused (Boolean):** Sets the initial playback state. Defaults to false (play on load).
* **isMuted (Boolean):** Indicates whether the video is muted initially. Defaults to false.
* **initialSpeed (PlayerSpeed):** Sets the initial playback speed. Defaults to PlayerSpeed.X1.
* **initialVideoFitMode (ScreenResize):** Specifies the video resizing mode. Defaults to ScreenResize.FILL.
* **isLooping (Boolean):** Enables or disables looping. Defaults to true.
* **startTimeInSeconds (Int?):** Optionally specifies the start time (in seconds) for the video. Defaults to null.

### Available Controls
* **loadUrl(url: String):** Updates the video URL to load a new video.
* **play():** Resumes video playback.
* **pause():** Pauses video playback.
* **togglePlayPause():** Toggles between play and pause states.
* **mute():** Mutes the video.
* **unmute():** Unmutes the video.
* **toggleMuteUnmute():** Toggles between muted and unmuted states.
* **setSpeed(speed: PlayerSpeed):** Adjusts the playback speed.
* **seekTo(seconds: Int?):** Seeks to a specific time in the video.
* **setVideoFitMode(mode: ScreenResize):** Updates the video resizing mode.
* **setLooping(isLooping: Boolean):** Enables or disables looping.
* **setVolume(level: Float):** Adjusts the volume. Value must be between 0.0 and 1.0.

### Internal Updates and Events
The VideoPlayerHost class manages internal state changes and triggers events via the onEvent callback. These events allow developers to monitor and respond to changes in the video player state:

| Event                                | Description                                                                        |
|--------------------------------------|------------------------------------------------------------------------------------|
| PauseChange(isPaused: Boolean)       | Triggered when the playback state changes (play or pause).                         |
| MuteChange(isMuted: Boolean)         | Triggered when the mute state changes (mute or unmute).                            |
| BufferChange(isBuffering: Boolean)   | Triggered when the buffering state changes (e.g., when buffering starts/stops).    |
| TotalTimeChange(totalTime: Int)      | Triggered when the total duration of the video updates.                            |
| CurrentTimeChange(currentTime: Int)  | Triggered when the current playback position updates.                              |
| VideoEnd                             | Triggered when the video playback completes.                                       |

### Example Usage
```kotlin
val videoPlayerHost = VideoPlayerHost(
    url = "https://example.com/video.mp4",
    isPaused = true,
    isMuted = false,
    initialSpeed = PlayerSpeed.X1,
    initialVideoFitMode = ScreenResize.FIT,
    isLooping = false,
    startTimeInSeconds = 10
)

// Play the video
videoPlayerHost.play()

// Pause the video
videoPlayerHost.pause()

// Toggle mute
videoPlayerHost.toggleMuteUnmute()

// Seek to 30 seconds
videoPlayerHost.seekTo(30)

// Change playback speed to 1.5x
videoPlayerHost.setSpeed(PlayerSpeed.X1_5)

// Enable looping
videoPlayerHost.setLooping(true)

videoPlayerHost.onEvent = { event ->
    when (event) {
        is VideoPlayerEvent.MuteChange -> { println("Mute status changed: ${event.isMuted}") }
        is VideoPlayerEvent.PauseChange -> { println("Pause status changed: ${event.isPaused}") }
        is VideoPlayerEvent.BufferChange -> { println("Buffering status: ${event.isBuffering}") }
        is VideoPlayerEvent.CurrentTimeChange -> { println("Current playback time: ${event.currentTime}s") }
        is VideoPlayerEvent.TotalTimeChange -> { println("Video duration updated: ${event.totalTime}s") }
        VideoPlayerEvent.VideoEnd -> { println("Video playback ended") }
    }
}
```

### 📹 Video Player
To play videos in your app, use the VideoPlayerComposable:
```kotlin
val playerHost = remember { VideoPlayerHost(url = url) }

VideoPlayerComposable(
    modifier = Modifier.fillMaxSize(),
    playerHost = playerHost
)
```
💡 **Note:** The VideoPlayerComposable supports both online and local video playback. You can provide a URL for a remote video or a local file path.

### 📹 Video Preview
To display video preview thumbnails, use the VideoPreviewComposable:
```kotlin
VideoPreviewComposable(
    url = videoUrl,
    frameCount = 5
)
```
💡 **Note:** The VideoPreviewComposable does not support local asset video in Android.

### ▶️ YouTube Player
To play youtube videos in your app, use the YouTubePlayerComposable:
```kotlin
val playerHost = remember { VideoPlayerHost(url = youtubeVideoId) }

YouTubePlayerComposable(
    modifier = Modifier.fillMaxSize(),
    playerHost = playerHost
)
```
💡 **Note:** The YouTubePlayerComposable supports both YouTube video URLs and video IDs. It automatically extracts the video ID if a full URL is provided, ensuring seamless playback.

### 🎥 Reel Viewing
For reel viewing, utilize the ReelsPlayerComposable:
```kotlin
ReelsPlayerComposable(
    modifier = Modifier.fillMaxSize(),
    urls = videoUrlArray
)
```

### 🎧 Audio Player
To play audio in your app, use the AudioPlayerComposable:
```kotlin
AudioPlayerComposable(
    modifier = Modifier,
    audios = audioFilesArray
)
```
💡 **Note:** The AudioPlayerComposable supports both online and local audio playback. You can provide a URL for a remote audio file or a local file path.

## ⚙️ Customization
You can customize various aspects of the media player:

* `modifier`: Modifies the layout and appearance of the video player and reel player.
* `playerHost`: The VideoPlayerHost class manages internal state changes of video player.
* `urls`: An array of URLs for the reel player, allowing playback of multiple reels.
* `playerConfig`: You can configure various aspects of the video player appearance using the VideoPlayerConfig data class.

| Property                                              | Description                                                                                                                     |
|-------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| showControls                                          | Hide/Show video player inbuilt controls.                                                                                        |
| isPauseResumeEnabled                                  | Enable or disable the pause/resume functionality.                                                                               |
| isSeekBarVisible                                      | Toggle the visibility of the seek bar.                                                                                          |
| isDurationVisible                                     | Control the display of the playback time duration.                                                                              |
| seekBarThumbColor                                     | Customize the color of the seek bar thumb.                                                                                      |
| seekBarActiveTrackColor                               | Customize the color of the seek bar’s active track, representing the portion of the media content that has already been played. |
| seekBarInactiveTrackColor                             | Customize the color of the seek bar’s inactive track, representing the remaining portion of the media content yet to be played. |
| durationTextColor                                     | Customize the color of the duration text displayed alongside the seek bar.                                                      |
| durationTextStyle                                     | Customize the text style of the duration text, including font size and weight.                                                  |
| seekBarBottomPadding                                  | Configure the bottom padding for the seek bar control, ensuring proper alignment within the UI layout.                          |
| playIconResource & pauseIconResource                  | Customize the play and pause button icons.                                                                                      |
| pauseResumeIconSize                                   | Customize the size of the pause/resume icons.                                                                                   |
| reelVerticalScrolling                                 | Manage vertical and horizontal scrolling in reel viewing.                                                                       |
| isAutoHideControlEnabled & controlHideIntervalSeconds | Enable the automatic hiding of controls after a specified time interval (in seconds).                                           |
| isFastForwardBackwardEnabled                          | Enable or disable fast forward and backward controls.                                                                           |
| fastForwardBackwardIconSize                           | Customize the size of the fast forward/backward icons.                                                                          |
| fastForwardIconResource & fastBackwardIconResource    | Customize the icons for fast forward and fast backward controls.                                                                |
| fastForwardBackwardIntervalSeconds                    | Set the interval (in seconds) for fast forward and backward actions.                                                            |
| isMuteControlEnabled                                  | Enable or disable mute control functionality.                                                                                   |
| unMuteIconResource & muteIconResource                 | Customize the icons for unmute and mute controls.                                                                               |
| topControlSize                                        | Customize the size of the top control buttons.                                                                                  |
| isSpeedControlEnabled                                 | Enable or disable speed control functionality.                                                                                  |
| speedIconResource                                     | Customize the icon for speed control.                                                                                           |
| isFullScreenEnabled                                   | Enable or disable full-screen functionality.                                                                                    |
| controlTopPadding                                     | Configure the top padding for controls, ensuring proper alignment within the UI layout.                                         |
| isScreenLockEnabled                                   | Enable or disable screen lock functionality.                                                                                    |
| iconsTintColor                                        | Customize the tint color of the control icons.                                                                                  |
| isScreenResizeEnabled                                 | Enable or disable screen resize (Fit/Fill) functionality.                                                                       |
| loadingIndicatorColor                                 | Customize the color of the loading indicator.                                                                                   |
| loaderView                                            | Custom loader for showing loading state.                                                                                        |
| isLiveStream                                          | A boolean property that indicates whether the currently playing video is a live stream.                                         |

* `audioPlayerConfig`: You can configure various aspects of the audio player appearance and behavior using the AudioPlayerConfig data class.
  
| Property                                       | Description                                                                                                                     |
|------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| isControlsVisible                              | Toggle the visibility of the player controls.                                                                                   |
| backgroundColor                                | Customize the background color of the audio player.                                                                             |
| coverBackground                                | Customize the background color of the cover image.                                                                              |
| seekBarThumbColor                              | Customize the color of the seek bar thumb.                                                                                      |
| seekBarActiveTrackColor                        | Customize the color of the seek bar’s active track, representing the portion of the media content that has already been played. |
| seekBarInactiveTrackColor                      | Customize the color of the seek bar’s inactive track, representing the remaining portion of the media content yet to be played. |
| fontColor                                      | Customize the color of the text used in the player.                                                                             |
| durationTextStyle                              | Customize the text style of the duration text, including font size and weight.                                                  |
| titleTextStyle                                 | Customize the text style of the title text, including font size and weight.                                                     |
| controlsBottomPadding                          | Configure the bottom padding for the controls, ensuring proper alignment within the UI layout.                                  |
| playIconResource & pauseIconResource           | Customize the play and pause button icons.                                                                                      |
| pauseResumeIconSize                            | Customize the size of the pause/resume icons.                                                                                   |
| previousNextIconSize                           | Customize the size of the previous and next track icons.                                                                        |
| previousIconResource & nextIconResource        | Customize the icons for the previous and next track controls.                                                                   |
| iconsTintColor                                 | Customize the tint color of the control icons.                                                                                  |
| loadingIndicatorColor                          | Customize the color of the loading indicator.                                                                                   |
| shuffleOnIconResource & shuffleOffIconResource | Customize the icons for the shuffle control when enabled and disabled.                                                          |
| advanceControlIconSize                         | Customize the size of the advance control icons (e.g., fast forward/backward).                                                  |
| repeatOnIconResource & repeatOffIconResource   | Customize the icons for the repeat control when enabled and disabled.                                                           |


```kotlin
val playerHost = remember { VideoPlayerHost(url = videoUrl) }

VideoPlayerComposable(modifier = Modifier.fillMaxSize(),
                playerHost = playerHost,
                playerConfig = VideoPlayerConfig(
                    isPauseResumeEnabled = true,
                    isSeekBarVisible = true,
                    isDurationVisible = true,
                    seekBarThumbColor = Color.Red,
                    seekBarActiveTrackColor = Color.Red,
                    seekBarInactiveTrackColor = Color.White,
                    durationTextColor = Color.White,
                    seekBarBottomPadding = 10.dp,
                    pauseResumeIconSize = 40.dp,
                    isAutoHideControlEnabled = true,
                    controlHideIntervalSeconds = 5,
                    isFastForwardBackwardEnabled = true,
                    playIconResource = Res.drawable.icn_play,
                    pauseIconResource = Res.drawable.icn_pause,
                )
            )
```

```kotlin
VideoPreviewComposable(
    url = videoUrl,
    loadingIndicatorColor = Color.White,
    frameCount = 5
)
```

```kotlin
val playerHost = remember { VideoPlayerHost(url = "QFxN2oDKk0E") }

YouTubePlayerComposable(modifier = Modifier.fillMaxSize(),
                playerHost = playerHost,
                playerConfig = VideoPlayerConfig(
                    isPauseResumeEnabled = true,
                    isSeekBarVisible = true,
                    isDurationVisible = true,
                    seekBarThumbColor = Color.Red,
                    seekBarActiveTrackColor = Color.Red,
                    seekBarInactiveTrackColor = Color.White,
                    durationTextColor = Color.White,
                    seekBarBottomPadding = 10.dp,
                    pauseResumeIconSize = 40.dp,
                    isAutoHideControlEnabled = true,
                    controlHideIntervalSeconds = 5,
                    isFastForwardBackwardEnabled = true,
                    playIconResource = Res.drawable.icn_play,
                    pauseIconResource = Res.drawable.icn_pause,
                )
            )
```


```kotlin
ReelsPlayerComposable(modifier = Modifier.fillMaxSize(),
        urls = videoUrlArray,
        playerConfig = VideoPlayerConfig(
            isPauseResumeEnabled = true,
            isSeekBarVisible = false,
            isDurationVisible = false,
            isMuteControlEnabled = false,
            isSpeedControlEnabled = false,
            isFullScreenEnabled = false,
            isScreenLockEnabled = false,
            reelVerticalScrolling = true
        )
    )
```

```kotlin
val audioFilesArray = listOf(
        AudioFile(
            audioUrl = "https://codeskulptor-demos.commondatastorage.googleapis.com/GalaxyInvaders/theme_01.mp3",
            audioTitle = "Galaxy Invaders",
            thumbnailUrl = "https://c.saavncdn.com/866/On-My-Way-English-2019-20190308195918-500x500.jpg"
        ),
        AudioFile(
            audioUrl = "https://codeskulptor-demos.commondatastorage.googleapis.com/pang/paza-moduless.mp3",
            audioTitle = "Paza Moduless"
        )
    )

AudioPlayerComposable(
        modifier = Modifier,
        audios = audioFilesArray,
        audioPlayerConfig = AudioPlayerConfig(
            isControlsVisible = true,
            fontColor = Color.White,
            iconsTintColor = Color.White
        )
    )
```

## 📀 Format Support
|  Format  | Android  |   iOS    | Desktop  |
|:--------:|:--------:|:--------:|:--------:|
|   MP4    |    ✅     |    ✅     |    ✅     |
|   MOV    |    ✅     |    ✅     |    ✅     |
|   3GP    |    ✅     |    ✅     |    ✅     |
|   AVI    |    ✅     |    ❌     |    ✅     |
|   MKV    |    ✅     |    ❌     |    ✅     |
|   WEBM   |    ✅     |    ❌     |    ✅     |
|   MTS    |    ✅     |    ❌     |    ✅     |
|   m3u8   |    ✅     |    ✅     |    ✅     |
|   MP3    |    ✅     |    ✅     |    ✅     |
|   FLAC   |    ✅     |    ✅     |    ✅     |
|   WAV    |    ✅     |    ✅     |    ✅     |
|   AAC    |    ✅     |    ❌     |    ✅     |
|   AIF    |    ❌     |    ✅     |    ✅     |
|   ALAC   |    ✅     |    ❌     |    ✅     |
|   OGG    |    ✅     |    ❌     |    ✅     |
| YouTube  |    ✅     |    ✅     |    ✅     |

## 📖 Detailed Explanation
For an in-depth guide and detailed explanation, check out our comprehensive Medium Blog Post.

[![Medium](https://img.shields.io/badge/Medium-12100E?style=for-the-badge&logo=medium&logoColor=white)](https://medium.com/mobile-innovation-network/introducing-compose-multiplatform-media-player-your-go-to-solution-for-seamless-media-playback-691df3cc4da9)  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/showcase/mobile-innovation-network)

## 🛤️ Roadmap
We're committed to continuously improving and expanding the capabilities of our media player library. Here's a glimpse into our future plans:

### 🌟 Upcoming Features
- Picture-in-Picture (PiP) Mode
- Video Caching for iOS & Desktop

## 📄 License
```
Copyright 2023 Mobile Innovation Network

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```