
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.chaintech.app.MainView
import java.awt.Dimension

fun main() = application {
    Window(
        title = "MediaPlayer",
        state = rememberWindowState(width = 900.dp, height = 700.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(600, 600)
        MainView()
    }
}
