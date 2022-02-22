package com.decline.moneymanagerv2.app_features.presentation.util

import com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen.AddEditTransactionEvent

sealed class UiEvent {
    data class ShowSnackBar(val message: String) : UiEvent()
    object SaveTransaction : UiEvent()
    object OnBackClick : UiEvent()
    object OnDeleteClick : UiEvent()
}
