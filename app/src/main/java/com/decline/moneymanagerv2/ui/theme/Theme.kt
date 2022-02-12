package com.decline.moneymanagerv2.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    background = BackgroundDark,
    surface = SurfaceDark,
    primary = PrimaryDark,
    secondary = SecondaryDark,
    onSecondary = OnSecondaryDark
)

private val LightColorPalette = lightColors(
    background = BackgroundLight,
    surface = SurfaceLight,
    primary = PrimaryLight,
    secondary = SecondaryLight,
    onSecondary = OnSecondaryLight

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun MoneyManagerV2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val systemUiController = rememberSystemUiController()
    if (darkTheme) {
        systemUiController.setStatusBarColor(
            color = SurfaceDark
        )
    } else {
        systemUiController.setStatusBarColor(
            color = SurfaceLight
        )
    }
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    CompositionLocalProvider(LocalSpacing provides Dimensions()) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }

}