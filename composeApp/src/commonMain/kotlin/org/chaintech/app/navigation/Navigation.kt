package org.chaintech.app.navigation

import androidx.compose.runtime.compositionLocalOf
import org.chaintech.app.model.VideoModel

interface Navigation {
    fun back(): Boolean
    fun backToRoot(): Boolean

    fun goToVideoPlayerScreen(currentVideo: VideoModel, videoList: List<VideoModel>): Boolean
}

val LocalNavigation = compositionLocalOf<Navigation> { error("navigation failure") }