package com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.decline.moneymanagerv2.ui.theme.LocalSpacing
import com.decline.moneymanagerv2.ui.theme.TextFieldRowCursorColor
import com.decline.moneymanagerv2.ui.theme.TextFieldRowTextColor

@Composable
fun TextFieldRow(
    text: String,
    value: String,
    color: Color,
    isEditable: Boolean,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val spacing = LocalSpacing.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h4,
            softWrap = false,
            color = MaterialTheme.colors.TextFieldRowTextColor,
            modifier = Modifier
                .padding(start = spacing.spaceSmall)
                .weight(.25f)
        )
        TextField(
            modifier = Modifier
                .padding(end = spacing.spaceMedium)
                .weight(.7f),
            readOnly = !isEditable,
            singleLine = true,
            value = value,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface,
                focusedIndicatorColor = color,
                cursorColor = MaterialTheme.colors.TextFieldRowCursorColor
            )
        )

    }

}