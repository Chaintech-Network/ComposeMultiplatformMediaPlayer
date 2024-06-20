package chainteck.network.app.utility

import androidx.compose.runtime.Composable

@Composable
expect fun SystemAppearance()

expect fun getSafeAreaHeight(): SafeAreaSize