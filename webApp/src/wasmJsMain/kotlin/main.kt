import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import org.chaintech.app.MainView

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    // 將 Compose 渲染到指定的 HTML 容器，以便透過 CSS 控制層級
    ComposeViewport("compose-target") {
        MainView()
    }
}
