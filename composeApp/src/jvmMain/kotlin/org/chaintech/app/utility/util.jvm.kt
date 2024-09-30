package org.chaintech.app.utility

import androidx.compose.runtime.Composable
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
