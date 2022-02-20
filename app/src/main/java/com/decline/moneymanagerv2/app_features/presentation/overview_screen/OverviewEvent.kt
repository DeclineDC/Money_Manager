package com.decline.moneymanagerv2.app_features.presentation.overview_screen

sealed class OverviewEvent {
    object PreviousDate : OverviewEvent()
    object NextDate : OverviewEvent()
}
