package com.decline.moneymanagerv2.app_features.presentation.util

sealed class Screen(val route: String) {
    object OverviewScreen: Screen("overview_screen")
    object AddEditTransactionScreen: Screen("add_edit_transaction_screen")
}
