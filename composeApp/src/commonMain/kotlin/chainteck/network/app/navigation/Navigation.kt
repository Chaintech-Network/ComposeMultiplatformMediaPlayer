package chainteck.network.app.navigation

import androidx.compose.runtime.compositionLocalOf
import chainteck.network.app.model.VideoModel

interface Navigation {
    fun back(): Boolean
    fun backToRoot(): Boolean

    fun goToVideoPlayerScreen(currentVideo: VideoModel): Boolean
}

val LocalNavigation = compositionLocalOf<Navigation> { error("navigation failure") }