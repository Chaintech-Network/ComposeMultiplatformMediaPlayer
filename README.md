# Compose Multiplatform Media Player

Compose Multiplatform Media Player is a powerful media player library designed for Compose Multiplatform projects. It enables seamless video playback and reels viewing on both iOS and Android platforms, offering extensive customization options for various controls.

![Blog-banner-02 3](https://github.com/ChainTechNetwork/ComposeMultiplatformMediaPlayer/assets/143475887/754150a6-e86e-4a67-87fe-a600e90a4578)

## Features
**Cross-Platform Compatibility:** Works seamlessly on both iOS and Android platforms within Compose Multiplatform projects.

**Video Playback:** Effortlessly play videos in your app with high performance and reliability.

**Reel Viewing:** Enjoy reel viewing with support for horizontal and vertical scrolling.

**Customizable Controls:** Enable/disable pause/resume functionality and adjust the appearance and visibility of the seek bar, along with various control icons and colors.

## Installation

Add the following dependency to your `build.gradle.kts` file:

```kotlin
commonMain.dependencies {
    implementation("network.chaintech:compose-multiplatform-media-player:1.0.7")
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

| Property                             | Description |
| ------------------------------------ | ----------- |
| isPauseResumeEnabled               | Enable or disable the pause/resume functionality. |
| isSeekBarVisible                   | Toggle the visibility of the seek bar. |
| isDurationVisible                  | Control the display of the playback time duration. |
| seekBarThumbColor                  | Customize the color of the seek bar thumb. |
| seekBarActiveTrackColor            | Customize the color of the seek bar’s active track, representing the portion of the media content that has already been played. |
| seekBarInactiveTrackColor          | Customize the color of the seek bar’s inactive track, representing the remaining portion of the media content yet to be played. |
| durationTextColor                  | Customize the color of the duration text displayed alongside the seek bar. |
| durationTextStyle                  | Customize the text style of the duration text, including font size and weight. |
| seekBarBottomPadding              | Configure the bottom padding for the seek bar control, ensuring proper alignment within the UI layout. |
| playIconResource & pauseIconResource | Customize the play and pause button icons. |
| pauseResumeIconSize                | Customize the size of the pause/resume icons. |
| reelVerticalScrolling              | Manage vertical and horizontal scrolling in reel viewing. |
| isAutoHideControlEnabled & controlHideIntervalSeconds | Enable the automatic hiding of controls after a specified time interval (in seconds). |
| isFastForwardBackwardEnabled       | Enable or disable fast forward and backward controls. |
| fastForwardBackwardIconSize       | Customize the size of the fast forward/backward icons. |
| fastForwardIconResource & fastBackwardIconResource | Customize the icons for fast forward and fast backward controls. |
| fastForwardBackwardIntervalSeconds | Set the interval (in seconds) for fast forward and backward actions. |
| isMuteControlEnabled               | Enable or disable mute control functionality. |
| unMuteIconResource & muteIconResource | Customize the icons for unmute and mute controls. |
| topControlSize                     | Customize the size of the top control buttons. |
| isSpeedControlEnabled             | Enable or disable speed control functionality. |
| speedIconResource                  | Customize the icon for speed control. |
| isFullScreenEnabled                | Enable or disable full-screen functionality. |
| controlTopPadding                  | Configure the top padding for controls, ensuring proper alignment within the UI layout. |
| isScreenLockEnabled                | Enable or disable screen lock functionality. |
| iconsTintColor                    | Customize the tint color of the control icons. |


```kotlin
VideoPlayerView(modifier = Modifier.fillMaxSize(),
                url = videoUrl,
                playerConfig = PlayerConfig(
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
ReelsPlayerView(modifier = Modifier.fillMaxSize(),
        urls = videoUrlArray,
        playerConfig = PlayerConfig(
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

![media-player-animation](https://github.com/ChainTechNetwork/ComposeMultiplatformMediaPlayer/assets/143475887/3c0d2f57-8741-4e46-8e4e-9ee3040eedf1)


## Detailed Explanation
For a detailed explanation and a comprehensive guide, please read the [Medium blog post.](https://medium.com/mobile-innovation-network/introducing-compose-multiplatform-media-player-your-go-to-solution-for-seamless-media-playback-691df3cc4da9)
