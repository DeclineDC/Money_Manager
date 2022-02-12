package com.decline.moneymanagerv2.app_features.presentation.balance_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.decline.moneymanagerv2.app_features.presentation.balance_screen.components.DateSelector
import com.decline.moneymanagerv2.ui.theme.LocalSpacing
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BalanceScreen(
    navController: NavController
) {
    val spacing = LocalSpacing.current
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

    }

}