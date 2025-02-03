package org.chaintech.app.utility

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import java.io.File

@Composable
actual fun SystemAppearance() {
}

actual fun getSafeAreaHeight(): SafeAreaSize {
    return SafeAreaSize()
}

actual fun getLocalFilePathFor(item: String): String {
    val classLoader = Thread.currentThread().contextClassLoader
    val resource = classLoader.getResource(item)
    return resource?.let { File(it.file).absolutePath } ?: ""
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun screenWidth(): Float {
    val density = LocalDensity.current
    val screenSize = LocalWindowInfo.current.containerSize
    val width = with(density) { screenSize.width.toDp() }
    return width.value
}