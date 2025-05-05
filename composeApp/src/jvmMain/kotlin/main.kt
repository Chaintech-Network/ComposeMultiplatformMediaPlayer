
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import chaintech.videoplayer.util.LocalWindowState
import org.chaintech.app.MainView
import java.awt.Dimension

fun main() = application {
    val windowState = rememberWindowState(width = 900.dp, height = 700.dp)
    CompositionLocalProvider(LocalWindowState provides windowState) {
        Window(
            title = "MediaPlayer",
            state = windowState,
            onCloseRequest = ::exitApplication,
        ) {
            window.minimumSize = Dimension(600, 600)
            MainView()
        }
    }
}
