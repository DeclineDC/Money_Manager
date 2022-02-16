package com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.decline.moneymanagerv2.ui.theme.White

@Composable
fun AddButton(
    text: String,
    onClick: () -> Unit,
    color: Color,
    modifier: Modifier = Modifier,

    ) {
    Button(
        onClick = {
            onClick
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        modifier = modifier
            .fillMaxWidth(.75f)
    ) {
        Text(text = text, color = White)
    }
}

