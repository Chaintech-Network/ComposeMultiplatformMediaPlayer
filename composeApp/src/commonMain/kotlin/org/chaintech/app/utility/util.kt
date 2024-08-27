package org.chaintech.app.utility

import androidx.compose.runtime.Composable

@Composable
expect fun SystemAppearance()

expect fun getSafeAreaHeight(): SafeAreaSize

expect fun getLocalFilePathFor(item: String): String