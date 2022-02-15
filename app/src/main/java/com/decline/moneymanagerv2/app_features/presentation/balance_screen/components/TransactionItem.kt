package com.decline.moneymanagerv2.app_features.presentation.balance_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.decline.moneymanagerv2.app_features.domain.model.Transaction
import com.decline.moneymanagerv2.ui.theme.Persimmon
import com.decline.moneymanagerv2.ui.theme.SeaGreen
import com.decline.moneymanagerv2.ui.theme.LocalSpacing
import com.decline.moneymanagerv2.ui.theme.TransactionInfoDateTextColor

@Composable
fun TransactionItem(
    transaction: Transaction,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current

    Column(
        modifier = modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = spacing.spaceMedium,
                    end = spacing.spaceMedium,
                    bottom = spacing.spaceSmall,
                    top = spacing.spaceSmall
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = transaction.description, style = MaterialTheme.typography.body1)
            Text(
                modifier = Modifier.offset(y = 12.dp),
                text = "€ ${transaction.amount}",
                style = MaterialTheme.typography.h3,
                color = if (transaction.isExpense) Persimmon else SeaGreen
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = spacing.spaceMedium, bottom = spacing.spaceSmall),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "${transaction.dayOfMonth}" + "/${transaction.month}" + "/${transaction.year}",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.TransactionInfoDateTextColor
            )
        }
        Divider(thickness = .5.dp)
    }


}