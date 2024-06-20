package chainteck.network.app.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import chainteck.network.app.utility.SystemAppearance
import network.chaintech.sdpcomposemultiplatform.sdp
import network.chaintech.sdpcomposemultiplatform.ssp


@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    SystemAppearance()

    val typography = Typography(
        bodyMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.ssp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.sdp),
        medium = RoundedCornerShape(4.sdp),
        large = RoundedCornerShape(0.sdp)
    )

    ProvideColors(colors) {
        MaterialTheme(
            colorScheme = debugColors(),
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}


private val LightColorPalette = ColorPalette(
    white = White,
    gradientPrimary = GradientPrimary,
    secondaryText = SecondaryText,
    homeTopGradient = HomeTopGradient,
    bottomTabBarColor = BottomTabBarColor,
    border = Border
)

private val DarkColorPalette = ColorPalette(
    white = White,
    gradientPrimary = GradientPrimary,
    secondaryText = SecondaryText,
    homeTopGradient = HomeTopGradient,
    bottomTabBarColor = BottomTabBarColor,
    border = Border
)

/**
 * App custom Color Palette
 */
@Stable
class ColorPalette(
    white: Color,
    gradientPrimary: List<Color>,
    homeTopGradient: List<Color>,
    secondaryText: Color,
    bottomTabBarColor: Color,
    border: Color
) {

    var white by mutableStateOf(white)
        private set
    var gradientPrimary by mutableStateOf(gradientPrimary)
        private set
    var secondaryText by mutableStateOf(secondaryText)
        private set
    var homeTopGradient by mutableStateOf(homeTopGradient)
        private set
    var border by mutableStateOf(border)
        private set
    var bottomTabBarColor by mutableStateOf(bottomTabBarColor)
        private set


    fun update(other: ColorPalette) {
        white = other.white
        gradientPrimary = other.gradientPrimary
        secondaryText = other.secondaryText
        homeTopGradient = other.homeTopGradient
        bottomTabBarColor = other.bottomTabBarColor
    }
}

object MyApplicationTheme {
    val colors: ColorPalette
        @Composable
        get() = LocalAppColor.current
}

@Composable
fun ProvideColors(
    colors: ColorPalette,
    content: @Composable () -> Unit
) {
    val colorPalette = remember { colors }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalAppColor provides colorPalette, content = content)
}

private val LocalAppColor = staticCompositionLocalOf<ColorPalette> {
    error("No AppColorPalette provided")
}


fun debugColors(
    debugColor: Color = Color.Transparent
) = ColorScheme(
    primary = debugColor,
    onPrimary = debugColor,
    primaryContainer = debugColor,
    onPrimaryContainer = debugColor,
    inversePrimary = debugColor,
    secondary = debugColor,
    onSecondary = debugColor,
    secondaryContainer = debugColor,
    onSecondaryContainer = debugColor,
    tertiary = debugColor,
    onTertiary = debugColor,
    tertiaryContainer = debugColor,
    onTertiaryContainer = debugColor,
    background = debugColor,
    onBackground = debugColor,
    surface = debugColor,
    onSurface = debugColor,
    surfaceVariant = debugColor,
    onSurfaceVariant = debugColor,
    surfaceTint = debugColor,
    inverseSurface = debugColor,
    inverseOnSurface = debugColor,
    error = debugColor,
    onError = debugColor,
    errorContainer = debugColor,
    onErrorContainer = debugColor,
    outline = debugColor,
    outlineVariant = debugColor,
    scrim = debugColor,
)