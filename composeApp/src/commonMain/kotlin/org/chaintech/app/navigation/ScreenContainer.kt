package org.chaintech.app.navigation

import androidx.compose.runtime.compositionLocalOf
import cafe.adriel.voyager.core.screen.Screen
import org.chaintech.app.model.VideoModel

interface ScreenContainer {
    fun goToVideoPlayerScreen(currentVideo: VideoModel, videoList: List<VideoModel>): Screen

}

val LocalScreenContainer =
    compositionLocalOf<ScreenContainer> { error("screen container not found") }
