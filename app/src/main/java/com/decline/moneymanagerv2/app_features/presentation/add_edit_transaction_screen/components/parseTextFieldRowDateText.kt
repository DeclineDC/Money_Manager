package com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen.components

import androidx.compose.runtime.Composable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun parseTextFieldRowDateText(date: LocalDate): String {
    return DateTimeFormatter.ofPattern("dd/MM/uuuu").format(date)
}