package chainteck.network.app.ui.screens.music

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import chaintech.videoplayer.model.AudioPlayerConfig
import chaintech.videoplayer.ui.audio.AudioPlayerView
import chainteck.network.app.model.MockData
import network.chaintech.sdpcomposemultiplatform.sdp

@Composable
fun MusicContentView() {
    AudioPlayerView(
        modifier = Modifier.fillMaxSize(),
        audios = MockData().audioFilesArray,
        audioPlayerConfig = AudioPlayerConfig(
            controlsBottomPadding = 30.sdp
        )
    )
}