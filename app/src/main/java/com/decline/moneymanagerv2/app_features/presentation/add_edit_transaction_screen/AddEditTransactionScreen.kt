package com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.decline.moneymanagerv2.R
import com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen.components.SelectableButton
import com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen.components.TextFieldRow
import com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen.components.TopBar
import com.decline.moneymanagerv2.ui.theme.LocalSpacing
import com.decline.moneymanagerv2.ui.theme.Persimmon
import com.decline.moneymanagerv2.ui.theme.SeaGreen

@Composable
fun AddEditTransactionScreen(
    navController: NavController,
    viewModel: AddEditTransactionViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current
    val scaffoldState = rememberScaffoldState()
    val isExpenseSelected = viewModel.isExpenseSelected

    Scaffold(scaffoldState = scaffoldState) {

        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(MaterialTheme.colors.surface)
        ) {
            TopBar(
                text =
                if (isExpenseSelected) stringResource(R.string.expense)
                else stringResource(R.string.income),
                onClick = { /*TODO*/ })
            Spacer(modifier = Modifier.padding(spacing.spaceSmall))
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(spacing.spaceSmall),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SelectableButton(
                    text = stringResource(id = R.string.income),
                    onClick = { viewModel.onEvent(AddEditTransactionEvent.IncomeSelected) },
                    isSelected = !isExpenseSelected,
                    color = SeaGreen
                )
                SelectableButton(
                    text = stringResource(id = R.string.expense),
                    onClick = { viewModel.onEvent(AddEditTransactionEvent.ExpenseSelected) },
                    isSelected = isExpenseSelected,
                    color = Persimmon
                )
            }
            Spacer(modifier = Modifier.padding(spacing.spaceSmall))
            TextFieldRow(
                text = stringResource(R.string.description),
                value = "",
                color = if (isExpenseSelected) Persimmon else SeaGreen,
                isEditable = true,
                onValueChange = {}
            )
            TextFieldRow(
                text = stringResource(R.string.amount),
                value = "",
                color = if (isExpenseSelected) Persimmon else SeaGreen,
                isEditable = true,
                onValueChange = {}
            )
            TextFieldRow(
                text = stringResource(R.string.date),
                value = "",
                color = if (isExpenseSelected) Persimmon else SeaGreen,
                isEditable = false,
                onValueChange = {}
            )
        }

    }

}