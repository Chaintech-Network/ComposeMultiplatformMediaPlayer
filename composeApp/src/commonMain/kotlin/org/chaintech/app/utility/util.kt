package org.chaintech.app.utility

import androidx.compose.runtime.Composable
import org.chaintech.app.utility.SafeAreaSize

@Composable
expect fun SystemAppearance()

expect fun getSafeAreaHeight(): SafeAreaSize