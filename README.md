# Compose Multiplatform Media Player

Compose Multiplatform Media Player is a powerful media player library designed for Compose Multiplatform projects. It enables seamless video playback and reels viewing on both iOS and Android platforms, offering extensive customization options for various controls.

![Blog-banner-02](https://github.com/ChainTechNetwork/ComposeMultiplatformMediaPlayer/assets/143475887/1e874d76-0ddc-49b2-a65e-dd5ca069bbcb)


## Features
**Cross-Platform Compatibility:** Works seamlessly on both iOS and Android platforms within Compose Multiplatform projects.

**Video Playback:** Effortlessly play videos in your app with high performance and reliability.

**Reel Viewing:** Enjoy reel viewing with support for horizontal and vertical scrolling.

**Customizable Controls:** Customize controls such as enabling/disabling pause/resume functionality and adjusting the appearance and visibility of the seek bar.

## Installation

Add the following dependency to your `build.gradle.kts` file:

```kotlin
commonMain.dependencies {
    implementation("network.chaintech:compose-multiplatform-media-player:1.0.5")
}
```

## Usage

### Video Playback
To play videos in your app, use the VideoPlayerView composable:
```kotlin
VideoPlayerView(
    modifier = Modifier.fillMaxSize(),
    url = videoUrl
)
```

### Reel Viewing
For reel viewing, utilize the ReelsPlayerView composable:
```kotlin
ReelsPlayerView(
    modifier = Modifier.fillMaxSize(),
    urls = videoUrlArray
)
```

## Customization
You can customize various aspects of the media player:

* `modifier`: Modifies the layout and appearance of the video player and reel player.
* `url`: The URL of the video to be played in the video player.
* `urls`: An array of URLs for the reel player, allowing playback of multiple reels.
* `playerConfig`: You can configure various aspects of the player appearance and behavior.
    - `enablePauseResume`: Enables or disables the pause and resume functionality in the media player, giving users control over playback.
    - `showSeekBar`: Controls the visibility of the seek bar, allowing users to seek through the video or reel content.
    - `showDuration`: Determines whether the playback time duration is displayed alongside the seek bar, providing users with information about the total duration of the media content.
    - `thumbColor`: Allows customization of the color of the seek bar thumb, which indicates the current position of the playback.
    - `activeTrackColor`: Enables setting the color of the seek bar's active track, representing the portion of the media content that has already been played.
    - `inactiveTrackColor`: Provides the option to set the color of the seek bar's inactive track, representing the remaining portion of the media content yet to be played.
    - `textColor`: Allows customization of the color of the duration text displayed alongside the seek bar, ensuring visibility and aesthetic consistency with the app's design.
    - `seekBarBottomPadding`: Allows configuring the bottom padding for the seek bar control, ensuring proper alignment within the UI layout.
    - `playIcon & pauseIcon`: Custom DrawableResource used as the play & pause button icon, providing flexibility in the appearance of the play & pause button.
    - `pauseResumeIconSize`: Customization of the size of the play and pause icons.
    - `reelVerticalScrolling`: Allows for the management of vertical and horizontal scrolling in the reel player, enabling a customizable viewing experience.
    - `autoHideControl & controlHideInterval`: These settings enable the automatic hiding of controls after a specified time interval, enhancing user experience by reducing clutter on the interface when controls are not in use.

![Git-animation-video-small](https://github.com/ChainTechNetwork/ComposeMultiplatformMediaPlayer/assets/143475887/b79fd69c-8eb3-4f89-9c6b-1f0cb5575933)

```kotlin
VideoPlayerView(modifier = Modifier.fillMaxSize(),
                url = videoUrl,
                playerConfig = PlayerConfig(
                    enablePauseResume = true,
                    showSeekBar = true,
                    showDuration = true,
                    thumbColor = Color.Red,
                    activeTrackColor = Color.Red,
                    inactiveTrackColor = Color.White,
                    textColor = Color.White,
                    seekBarBottomPadding = 10.dp,
                    playIcon = Res.drawable.icn_play,
                    pauseIcon = Res.drawable.icn_pause,
                    pauseResumeIconSize = 40.dp,
                    autoHideControl = true,
                    controlHideInterval = 5
                )
            )
```

```kotlin
ReelsPlayerView(modifier = Modifier.fillMaxSize(),
                url = videoUrlArray,
                playerConfig = PlayerConfig(
                    enablePauseResume = true,
                    showSeekBar = false,
                    playIcon = Res.drawable.icn_play,
                    pauseIcon = Res.drawable.icn_pause,
                    pauseResumeIconSize = 40.dp,
                    reelVerticalScrolling = true
                )
            )
```

