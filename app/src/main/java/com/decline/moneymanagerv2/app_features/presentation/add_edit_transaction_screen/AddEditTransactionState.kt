package com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen

import java.time.LocalDate

data class AddEditTransactionState(
    val description: String = "",
    val amount: String = "",
    val date: LocalDate = LocalDate.now(),
    val isExpenseSelected: Boolean = true

)