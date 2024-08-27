package org.chaintech.app.utility

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import platform.Foundation.NSBundle
import platform.UIKit.UIApplication
import platform.UIKit.UIStatusBarStyleLightContent
import platform.UIKit.UIWindow
import platform.UIKit.setStatusBarStyle

@Composable
actual fun SystemAppearance() {
    LaunchedEffect(Unit) {
        UIApplication.sharedApplication.setStatusBarStyle(
            UIStatusBarStyleLightContent
        )
    }
}


@OptIn(ExperimentalForeignApi::class)
actual fun getSafeAreaHeight(): SafeAreaSize {
    val window = UIApplication.sharedApplication.windows.first() as UIWindow
    val safeAreaInsets = window.safeAreaInsets
    val topPadding = memScoped {
        val top = safeAreaInsets.getPointer(this)
        top.pointed.top
    }
    val bottomPadding = memScoped {
        val bottom = safeAreaInsets.getPointer(this)
        bottom.pointed.bottom
    }

    return SafeAreaSize(top = topPadding.toFloat(), bottom = bottomPadding.toFloat())
}

actual fun getLocalFilePathFor(item: String): String {
    val videoFilePath = NSBundle.mainBundle.pathForResource(item, null)
    return videoFilePath ?: ""
}