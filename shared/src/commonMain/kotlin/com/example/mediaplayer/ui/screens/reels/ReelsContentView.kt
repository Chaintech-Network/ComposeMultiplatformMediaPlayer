package com.example.mediaplayer.ui.screens.reels

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import chaintech.videoplayer.model.PlayerConfig
import chaintech.videoplayer.ui.ReelsPlayerView
import com.example.mediaplayer.model.MockData
import network.chaintech.sdpcomposemultiplatform.sdp

@Composable
fun ReelsContentView() {
    ReelsPlayerView(
        modifier = Modifier
            .fillMaxSize(),
        urls = MockData().reelsUrlArray,
        playerConfig = PlayerConfig(
            enablePauseResume = true,
            showSeekBar = false,
            pauseResumeIconSize = 32.sdp,
            reelVerticalScrolling = true
        )
    )
}