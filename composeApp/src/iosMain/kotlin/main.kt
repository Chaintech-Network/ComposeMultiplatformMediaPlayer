import androidx.compose.ui.window.ComposeUIViewController
import org.chaintech.app.MainView
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { MainView() }
