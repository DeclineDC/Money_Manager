package com.decline.moneymanagerv2.app_features.presentation.balance_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.decline.moneymanagerv2.R
import com.decline.moneymanagerv2.app_features.presentation.balance_screen.components.BalanceBar
import com.decline.moneymanagerv2.app_features.presentation.balance_screen.components.DateSelector
import com.decline.moneymanagerv2.app_features.presentation.balance_screen.components.TransactionItem
import com.decline.moneymanagerv2.ui.theme.LocalSpacing
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BalanceScreen(
    navController: NavController,
    viewModel: BalanceViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                shape = RoundedCornerShape(spacing.spaceMedium),
                onClick = {
                },
                backgroundColor = MaterialTheme.colors.secondary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.add_transaction),
                    modifier = Modifier.size(spacing.spaceLarge)
                )
            }
        },
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                backgroundColor = MaterialTheme.colors.surface,
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 35)
                )
            ) {
            }
        }
    ) {
        Column(
            modifier = Modifier
        ) {
            DateSelector(
                date = LocalDate.now(),
                onPreviousDateClick = { /*TODO*/ },
                onNextDateClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.surface)
            )
            Divider(thickness = .5.dp)
            BalanceBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.surface)
                    .padding(spacing.spaceExtraSmall)
            )
            Divider(thickness = 1.dp, modifier = Modifier.shadow(elevation = 3.dp))
            Spacer(modifier = Modifier.padding(spacing.spaceExtraSmall))
            LazyColumn(contentPadding = PaddingValues(bottom = 80.dp)) {
                items(viewModel.transactions) { transaction ->
                    TransactionItem(
                        transaction = transaction,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colors.background)
                    )

                }
            }

        }
    }

}