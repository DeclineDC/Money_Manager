package com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.decline.moneymanagerv2.R
import com.decline.moneymanagerv2.ui.theme.LocalSpacing

@Composable
fun TopBar(
    text: String,
    onBackClick: () -> Unit,
    onDeleteClick: () -> Unit,
    isExistingTransaction: Boolean = false,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = spacing.spaceExtraSmall)
    ) {
        Row() {
            IconButton(
                onClick = onBackClick,
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                )
            }
            Spacer(modifier = Modifier.padding(spacing.spaceSmall))
            Text(
                text = text,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.offset(y = 10.dp)
            )
        }
        if (isExistingTransaction) {
            IconButton(
                onClick = onDeleteClick,
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = stringResource(R.string.delete),
                )
            }
        }
    }
}