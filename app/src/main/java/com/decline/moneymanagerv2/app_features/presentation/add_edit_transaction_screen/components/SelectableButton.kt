package com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.decline.moneymanagerv2.ui.theme.ButtonBorderColor
import com.decline.moneymanagerv2.ui.theme.ButtonTextColor
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
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(
            width = 2.dp,
            color = if (isSelected) color else MaterialTheme.colors.ButtonBorderColor
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor =
            if (isSelected) MaterialTheme.colors.SelectedButtonBackgroundColor
            else MaterialTheme.colors.UnselectedButtonBackgroundColor
        )
    ) {
        Text(
            text = text,
            color = if (isSelected) color else MaterialTheme.colors.ButtonTextColor,
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.SemiBold
        )
    }
}