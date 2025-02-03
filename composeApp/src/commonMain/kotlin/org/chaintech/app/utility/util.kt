package org.chaintech.app.utility

import androidx.compose.runtime.Composable

@Composable
expect fun SystemAppearance()

expect fun getSafeAreaHeight(): SafeAreaSize

expect fun getLocalFilePathFor(item: String): String

internal fun isLiveStream(url: String): Boolean {
    return url.endsWith(".m3u8")
}
@Composable
expect fun screenWidth(): Float