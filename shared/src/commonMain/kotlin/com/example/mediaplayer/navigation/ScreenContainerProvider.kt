package com.example.mediaplayer.navigation

import cafe.adriel.voyager.core.screen.Screen
import com.example.mediaplayer.model.VideoModel
import com.example.mediaplayer.ui.screens.videoplayerview.VideoPlayerView


class ScreenContainerProvider() : ScreenContainer {
    override fun goToVideoPlayerScreen(currentVideo: VideoModel): Screen = VideoPlayerView(currentVideo)
}

