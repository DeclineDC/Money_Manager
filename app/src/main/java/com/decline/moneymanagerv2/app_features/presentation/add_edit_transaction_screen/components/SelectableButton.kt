package com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.decline.moneymanagerv2.ui.theme.ButtonBorder
import com.decline.moneymanagerv2.ui.theme.ButtonText
import com.decline.moneymanagerv2.ui.theme.SelectedButtonBackgroundColor
import com.decline.moneymanagerv2.ui.theme.UnselectedButtonBackgroundColor

@Composable
fun SelectableButton(
    text: String,
    onClick: () -> Unit,
    isSelected: Boolean,
    color: Color,
    modifier: Modifier = Modifier,
) {

    OutlinedButton(
        onClick = onClick,
        border = BorderStroke(
            width = 1.dp,
            color = if (isSelected) color else MaterialTheme.colors.ButtonBorder
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor =
            if (isSelected) MaterialTheme.colors.SelectedButtonBackgroundColor
            else MaterialTheme.colors.UnselectedButtonBackgroundColor
        )
    ) {
        Text(
            text = text,
            color = if (isSelected) color else MaterialTheme.colors.ButtonText
        )
    }
}