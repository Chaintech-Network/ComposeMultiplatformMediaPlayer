package com.example.mediaplayer.navigation

import androidx.compose.runtime.compositionLocalOf
import cafe.adriel.voyager.core.screen.Screen
import com.example.mediaplayer.model.VideoModel

interface ScreenContainer {
    fun goToVideoPlayerScreen(currenctVideo: VideoModel): Screen

}

val LocalScreenContainer =
    compositionLocalOf<ScreenContainer> { error("screen container not found") }
