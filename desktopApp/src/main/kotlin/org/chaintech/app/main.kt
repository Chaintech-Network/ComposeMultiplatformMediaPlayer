package org.chaintech.app
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import chaintech.videoplayer.util.LocalWindowState
import java.awt.Dimension

fun main() = application {
    val windowState = rememberWindowState(width = 900.dp, height = 700.dp)
    Window(
        title = "MediaPlayer",
        state = windowState,
        onCloseRequest = ::exitApplication,
    ) {
        CompositionLocalProvider(LocalWindowState provides windowState) {
            window.minimumSize = Dimension(600, 600)
            MainView()
        }
    }
}
