package chainteck.network.app.navigation

import cafe.adriel.voyager.core.screen.Screen
import chainteck.network.app.model.VideoModel
import chainteck.network.app.ui.screens.videoplayerview.VideoPlayerView


class ScreenContainerProvider : ScreenContainer {
    override fun goToVideoPlayerScreen(currentVideo: VideoModel): Screen = VideoPlayerView(currentVideo)
}

