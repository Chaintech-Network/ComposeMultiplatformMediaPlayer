package org.chaintech.app.utility

import androidx.compose.runtime.Composable
import chaintech.videoplayer.util.isDesktop

@Composable
expect fun SystemAppearance()

expect fun getSafeAreaHeight(): SafeAreaSize

expect fun getLocalFilePathFor(item: String): String

internal fun isLiveStream(url: String): Boolean {
    return url.endsWith(".m3u8")
}

internal fun showSeperateBackButton(url: String) : Boolean {
    if(isDesktop()) {
        val regex = Regex(
            "https?:\\/\\/(?:www\\.|m\\.)?youtu(?:\\.be\\/|be\\.com\\/(?:watch\\?v=|embed\\/|v\\/|e\\/|live\\/|shorts\\/|user\\/))([^&#?\\n]+)"
        )
        return regex.find(url)?.groups?.get(1)?.value != null
    } else {
        return false
    }
}
@Composable
expect fun screenWidth(): Float