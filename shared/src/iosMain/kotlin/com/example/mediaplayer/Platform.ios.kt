package com.example.mediaplayer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.window.ComposeUIViewController
import com.example.mediaplayer.utility.SafeAreaSize
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import platform.UIKit.UIApplication
import platform.UIKit.UIStatusBarStyleLightContent
import platform.UIKit.UIWindow
import platform.UIKit.setStatusBarStyle


fun MainViewController() = ComposeUIViewController {
    MainView()
}

@Composable
actual fun SystemAppearance(isDark: Boolean) {
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
