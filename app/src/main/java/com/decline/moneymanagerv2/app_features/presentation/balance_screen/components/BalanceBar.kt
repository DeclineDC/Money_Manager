package com.decline.moneymanagerv2.app_features.presentation.balance_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.decline.moneymanagerv2.R
import com.decline.moneymanagerv2.ui.theme.ExpenseColor
import com.decline.moneymanagerv2.ui.theme.IncomeColor
import com.decline.moneymanagerv2.ui.theme.TotalColor

@Composable
fun BalanceBar(
    income: Double = 0.00,
    expenses: Double = 0.00,
    total: Double = 0.00,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BalanceInfo(text = stringResource(id = R.string.income), data = "$income", color = IncomeColor)
        BalanceInfo(text = stringResource(id = R.string.expenses), data = "$expenses", color = ExpenseColor)
        BalanceInfo(text = stringResource(id = R.string.total), data = "$total", color = TotalColor)
    }


    /*   Column() {
           Row(
               modifier = modifier,
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.SpaceEvenly
           ) {
               Text(text = stringResource(id = R.string.income))
               Text(text = stringResource(id = R.string.expenses))
               Text(text = stringResource(id = R.string.total))

           }
           Row(
               modifier = modifier,
               verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.SpaceEvenly
           ) {
               Text
           }
       }*/

}