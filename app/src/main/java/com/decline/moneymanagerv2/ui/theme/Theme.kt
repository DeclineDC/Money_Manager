package com.decline.moneymanagerv2.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    background = BlackBrown,
    surface = Shark,
    primary = Shark,
    secondary = SeaGreen,
    onSecondary = White
)

private val LightColorPalette = lightColors(
    background = AthensGray,
    surface = White,
    primary = White,
    secondary = SeaGreen,
    onSecondary = White

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
            color = Shark
        )
    } else {
        systemUiController.setStatusBarColor(
            color = White
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


val Colors.UnselectedButtonBackgroundColor: Color
    @Composable
    get() = if (isLight) WildSand else WoodSmoke

val Colors.SelectedButtonBackgroundColor: Color
    @Composable
    get() = if (isLight) White else Shark

val Colors.ButtonBorderColor: Color
    @Composable
    get() = if (isLight) Alto else Tuna

val Colors.ButtonTextColor: Color
    @Composable
    get() = if (isLight) Boulder else BomBay

val Colors.BalanceInfoTextColor: Color
    @Composable
    get() = if (isLight) Tundora else White

val Colors.TransactionInfoDateTextColor: Color
    @Composable
    get() = if (isLight) Gray else White

val Colors.TextFieldRowTextColor: Color
    @Composable
    get() = if (isLight) Boulder else BomBay

val Colors.TextFieldRowCursorColor: Color
    @Composable
    get() = if (isLight) Boulder else BomBay


