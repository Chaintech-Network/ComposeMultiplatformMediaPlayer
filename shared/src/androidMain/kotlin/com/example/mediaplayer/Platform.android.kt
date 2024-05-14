package com.example.mediaplayer

import android.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalView
import com.example.mediaplayer.utility.SafeAreaSize


@Composable
actual fun SystemAppearance(isDark: Boolean) {
//    val view = LocalView.current
//    val systemBarColor = Color.BLACK
//    LaunchedEffect(isDark) {
//        val window = (view.context as Activity).window
//        WindowCompat.setDecorFitsSystemWindows(window, false)
//        window.statusBarColor = systemBarColor
//        window.navigationBarColor = systemBarColor
//        WindowCompat.getInsetsController(window, window.decorView).apply {
//            isAppearanceLightStatusBars = isDark
//            isAppearanceLightNavigationBars = isDark
//        }
//    }
}

actual fun getSafeAreaHeight(): SafeAreaSize {
    return SafeAreaSize()
}

