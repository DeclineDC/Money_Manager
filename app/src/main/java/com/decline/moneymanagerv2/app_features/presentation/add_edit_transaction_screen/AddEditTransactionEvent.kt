package com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen

import com.decline.moneymanagerv2.app_features.domain.model.Transaction
import java.time.LocalDate

sealed class AddEditTransactionEvent {
    data class OnDescriptionChange(val value: String) : AddEditTransactionEvent()
    data class OnAmountChange(val value: String) : AddEditTransactionEvent()
    data class OnDeleteClick(val transaction: Transaction) : AddEditTransactionEvent()
    data class OnDateChange(val localDate: LocalDate): AddEditTransactionEvent()
    object OnBackClick : AddEditTransactionEvent()
    object OnExpenseSelected : AddEditTransactionEvent()
    object OnIncomeSelected : AddEditTransactionEvent()
    object OnSaveTransaction : AddEditTransactionEvent()
}
