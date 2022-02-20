package com.decline.moneymanagerv2.app_features.presentation.overview_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.decline.moneymanagerv2.R
import com.decline.moneymanagerv2.ui.theme.Persimmon
import com.decline.moneymanagerv2.ui.theme.SeaGreen
import com.decline.moneymanagerv2.ui.theme.DodgerBlue

@Composable
fun BalanceBar(
    income: Double,
    expenses: Double,
    balance: Double,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BalanceInfo(text = stringResource(id = R.string.income), data = "$income", color = SeaGreen)
        BalanceInfo(text = stringResource(id = R.string.expenses), data = "$expenses", color = Persimmon)
        BalanceInfo(text = stringResource(id = R.string.total), data = "$balance", color = DodgerBlue)
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