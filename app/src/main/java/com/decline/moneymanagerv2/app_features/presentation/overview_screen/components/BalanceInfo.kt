package com.decline.moneymanagerv2.app_features.presentation.overview_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.decline.moneymanagerv2.ui.theme.BalanceInfoTextColor

@Composable
fun BalanceInfo(
    text: String,
    data: String?,
    color: Color
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.BalanceInfoTextColor
        )
        Text(text = "$data", color = color, style = MaterialTheme.typography.h4)
    }

}