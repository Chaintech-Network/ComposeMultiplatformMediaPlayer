package org.chaintech.app.utility

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.browser.window
import org.w3c.dom.events.Event
import androidx.compose.runtime.*

@Composable
actual fun SystemAppearance() {

}

actual fun getSafeAreaHeight(): SafeAreaSize {
    return SafeAreaSize()
}

actual fun getLocalFilePathFor(item: String): String {
    return "/$item"
}

@Composable
actual fun screenWidth(): Float {
    var screenWidth by remember { mutableStateOf(window.innerWidth.toFloat()) }

    // Listen for resize events
    DisposableEffect(Unit) {
        val listener: (Event) -> Unit = {
            screenWidth = window.innerWidth.toFloat()
        }
        window.addEventListener("resize", listener)

        // Cleanup when composable is disposed
        onDispose { window.removeEventListener("resize", listener) }
    }

    return screenWidth
}