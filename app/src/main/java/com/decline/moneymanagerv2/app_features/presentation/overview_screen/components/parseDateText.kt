package com.decline.moneymanagerv2.app_features.presentation.overview_screen.components

import androidx.compose.runtime.Composable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun parseDateText(date: LocalDate): String {
    return DateTimeFormatter.ofPattern("LLL uuuu").format(date)
}