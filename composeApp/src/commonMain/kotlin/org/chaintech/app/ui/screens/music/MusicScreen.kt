package org.chaintech.app.ui.screens.music

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import chaintech.videoplayer.host.MediaPlayerHost
import chaintech.videoplayer.model.AudioPlayerConfig
import chaintech.videoplayer.ui.audio.AudioPlayerComposable
import network.chaintech.sdpcomposemultiplatform.sdp
import org.chaintech.app.model.MockData

@Composable
fun MusicScreen(){
    val playerHost = remember { MediaPlayerHost() }

    AudioPlayerComposable(
        modifier = Modifier.fillMaxSize(),
        audios = MockData().audioFilesArray,
        playerHost = playerHost,
        audioPlayerConfig = AudioPlayerConfig(
            controlsBottomPadding = 30.sdp
        )
    )
}