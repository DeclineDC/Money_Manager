package com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.decline.moneymanagerv2.R
import com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen.components.*
import com.decline.moneymanagerv2.app_features.presentation.util.Screen
import com.decline.moneymanagerv2.app_features.presentation.util.UiEvent
import com.decline.moneymanagerv2.ui.theme.LocalSpacing
import com.decline.moneymanagerv2.ui.theme.Persimmon
import com.decline.moneymanagerv2.ui.theme.SeaGreen
import kotlinx.coroutines.flow.collectLatest

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddEditTransactionScreen(
    navController: NavController,
    viewModel: AddEditTransactionViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current
    val scaffoldState = rememberScaffoldState()
    val isExpenseSelected = viewModel.state.isExpenseSelected

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
                is UiEvent.SaveTransaction -> {
                    navController.navigate(Screen.OverviewScreen.route)
                }
            }
        }
    }

    Scaffold(scaffoldState = scaffoldState, modifier = Modifier.fillMaxSize()) {

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
                onBackClick = {},
                onDeleteClick = {}
            )
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
                    color = SeaGreen,
                    modifier = Modifier.size(width = 125.dp, height = 35.dp)
                )
                SelectableButton(
                    text = stringResource(id = R.string.expense),
                    onClick = { viewModel.onEvent(AddEditTransactionEvent.ExpenseSelected) },
                    isSelected = isExpenseSelected,
                    color = Persimmon,
                    modifier = Modifier.size(width = 125.dp, height = 35.dp)
                )
            }
            Spacer(modifier = Modifier.padding(spacing.spaceSmall))
            TextFieldRow(
                text = stringResource(R.string.description),
                value = viewModel.state.description,
                color = if (isExpenseSelected) Persimmon else SeaGreen,
                isEditable = true,
                onValueChange = {viewModel.onEvent(AddEditTransactionEvent.EnteredDescription(it))}
            )
            TextFieldRow(
                text = stringResource(R.string.amount),
                value = viewModel.state.amount.toString(),
                color = if (isExpenseSelected) Persimmon else SeaGreen,
                isEditable = true,
                onValueChange = {viewModel.onEvent(AddEditTransactionEvent.EnteredAmount(it))}
            )
            TextFieldRow(
                text = stringResource(R.string.date),
                value = viewModel.state.date.toString(),
                color = if (isExpenseSelected) Persimmon else SeaGreen,
                isEditable = true,
                onValueChange = {},
            )
            Spacer(modifier = Modifier.fillMaxHeight(.1f))
            Divider(thickness = 1.dp, modifier = Modifier.shadow(elevation = 2.dp))
            Spacer(modifier = Modifier.fillMaxHeight(.1f))
            AddButton(
                modifier = Modifier.align(CenterHorizontally),
                text = stringResource(R.string.add),
                onClick = {viewModel.onEvent(AddEditTransactionEvent.SaveTransaction)},
                color = if (isExpenseSelected) Persimmon else SeaGreen
            )

        }
    }

}