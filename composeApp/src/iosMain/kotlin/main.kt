import androidx.compose.ui.window.ComposeUIViewController
import chainteck.network.app.MainView
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { MainView() }
