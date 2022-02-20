package com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen

import com.decline.moneymanagerv2.app_features.domain.model.Transaction

sealed class AddEditTransactionEvent {
    data class EnteredDescription(val value: String) : AddEditTransactionEvent()
    data class EnteredAmount(val value: String) : AddEditTransactionEvent()
    data class DeleteTransaction(val transaction: Transaction) : AddEditTransactionEvent()
    object ExpenseSelected : AddEditTransactionEvent()
    object IncomeSelected : AddEditTransactionEvent()
    object SaveTransaction : AddEditTransactionEvent()
    object ShowDatePicker : AddEditTransactionEvent()
}
