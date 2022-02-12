package com.decline.moneymanagerv2.app_features.presentation.util

sealed class UiEvent {
    data class ShowSnackBar(val message: String) : UiEvent()
    object SaveTransaction : UiEvent()
}
