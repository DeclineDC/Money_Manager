package com.decline.moneymanagerv2.app_features.presentation.balance_screen

sealed class BalanceEvent {
    object PreviousDate : BalanceEvent()
    object NextDate : BalanceEvent()
}
