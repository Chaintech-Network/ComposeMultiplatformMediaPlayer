package org.chaintech.app.navigation

import cafe.adriel.voyager.core.screen.Screen
import org.chaintech.app.model.VideoModel
import org.chaintech.app.ui.screens.videoplayerview.VideoPlayerView


class ScreenContainerProvider : ScreenContainer {
    override fun goToVideoPlayerScreen(currentVideo: VideoModel, videoList: List<VideoModel>): Screen = VideoPlayerView(currentVideo, videoList)
}

