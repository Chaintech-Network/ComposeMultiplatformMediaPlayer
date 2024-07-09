# Compose Multiplatform Media Player
Compose Multiplatform Media Player is a powerful media player library designed for Compose Multiplatform projects. It enables seamless video playback, reels viewing, and audio playing on both iOS and Android platforms, offering extensive customization options for various controls.

![Compose Multiplatform Media Player](https://github.com/ChainTechNetwork/ComposeMultiplatformMediaPlayer/assets/143475887/8045ac87-7620-44cd-9f26-5360f1b68109)


## Features
**Cross-Platform Compatibility:** Works seamlessly on both iOS and Android platforms within Compose Multiplatform projects.

**Video Playback:** Effortlessly play videos in your app with high performance and reliability.

**Reel Viewing:** Enjoy reel viewing with support for horizontal and vertical scrolling.

**Audio Playback:** Enjoy high-quality audio playback with customizable controls.

**Customizable Controls:** Enable/disable pause/resume functionality and adjust the appearance and visibility of the seek bar, along with various control icons and colors.

![Compose Multiplatform Media Player](https://github.com/ChainTechNetwork/ComposeMultiplatformMediaPlayer/assets/143475887/00a0c1ce-2da3-4052-8398-c022e645dd27)


## Installation

Add the following dependency to your `build.gradle.kts` file:

```kotlin
commonMain.dependencies {
    implementation("network.chaintech:compose-multiplatform-media-player:1.0.11")
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

### Audio Playback
To play audio in your app, use the AudioPlayerView composable:
```kotlin
AudioPlayerView(
    modifier = Modifier,
    audios = audioFilesArray
)
```

## Customization
You can customize various aspects of the media player:

* `modifier`: Modifies the layout and appearance of the video player and reel player.
* `url`: The URL of the video to be played in the video player.
* `urls`: An array of URLs for the reel player, allowing playback of multiple reels.
* `playerConfig`: You can configure various aspects of the video player appearance and behavior using the PlayerConfig data class.

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

* `audioPlayerConfig`: You can configure various aspects of the audio player appearance and behavior using the AudioPlayerConfig data class.
  
| Property                             | Description |
| ------------------------------------ | ----------- |
| isControlsVisible                    | Toggle the visibility of the player controls. |
| backgroundColor                      | Customize the background color of the audio player. |
| coverBackground                      | Customize the background color of the cover image. |
| seekBarThumbColor                    | Customize the color of the seek bar thumb. |
| seekBarActiveTrackColor              | Customize the color of the seek bar’s active track, representing the portion of the media content that has already been played. |
| seekBarInactiveTrackColor            | Customize the color of the seek bar’s inactive track, representing the remaining portion of the media content yet to be played. |
| fontColor                            | Customize the color of the text used in the player. |
| durationTextStyle                    | Customize the text style of the duration text, including font size and weight. |
| titleTextStyle                       | Customize the text style of the title text, including font size and weight. |
| controlsBottomPadding                | Configure the bottom padding for the controls, ensuring proper alignment within the UI layout. |
| playIconResource & pauseIconResource | Customize the play and pause button icons. |
| pauseResumeIconSize                  | Customize the size of the pause/resume icons. |
| previousNextIconSize                 | Customize the size of the previous and next track icons. |
| previousIconResource & nextIconResource | Customize the icons for the previous and next track controls. |
| iconsTintColor                       | Customize the tint color of the control icons. |
| loadingIndicatorColor                | Customize the color of the loading indicator. |
| shuffleOnIconResource & shuffleOffIconResource | Customize the icons for the shuffle control when enabled and disabled. |
| advanceControlIconSize               | Customize the size of the advance control icons (e.g., fast forward/backward). |
| repeatOnIconResource & repeatOffIconResource | Customize the icons for the repeat control when enabled and disabled. |


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

AudioPlayerView(
        modifier = Modifier,
        audios = audioFilesArray,
        audioPlayerConfig = AudioPlayerConfig(
            isControlsVisible = true,
            fontColor = Color.White,
            iconsTintColor = Color.White
        )
    )
```

## Detailed Explanation
For a detailed explanation and a comprehensive guide, please read the [Medium blog post.](https://medium.com/mobile-innovation-network/introducing-compose-multiplatform-media-player-your-go-to-solution-for-seamless-media-playback-691df3cc4da9)

Connect with us on [LinkedIn](https://www.linkedin.com/showcase/mobile-innovation-network)
