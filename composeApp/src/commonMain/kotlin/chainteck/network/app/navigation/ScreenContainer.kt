package chainteck.network.app.navigation

import androidx.compose.runtime.compositionLocalOf
import cafe.adriel.voyager.core.screen.Screen
import chainteck.network.app.model.VideoModel

interface ScreenContainer {
    fun goToVideoPlayerScreen(currentVideo: VideoModel): Screen

}

val LocalScreenContainer =
    compositionLocalOf<ScreenContainer> { error("screen container not found") }
