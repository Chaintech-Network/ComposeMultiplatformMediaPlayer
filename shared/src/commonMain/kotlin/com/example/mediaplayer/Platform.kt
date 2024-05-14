package com.example.mediaplayer

import androidx.compose.runtime.Composable
import com.example.mediaplayer.utility.SafeAreaSize


@Composable
expect fun SystemAppearance(isDark: Boolean)

expect fun getSafeAreaHeight(): SafeAreaSize

