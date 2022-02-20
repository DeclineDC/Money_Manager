package com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.decline.moneymanagerv2.app_features.domain.use_case.MoneyManagerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditTransactionViewModel @Inject constructor(
    private val moneyManagerUseCases: MoneyManagerUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var isExpenseSelected by mutableStateOf(true)
        private set

    private val _shouldShowDatePicker = mutableStateOf(false)
    val shouldShowDatePicker: State<Boolean> = _shouldShowDatePicker


    fun onEvent(event: AddEditTransactionEvent) {
        when (event) {
            is AddEditTransactionEvent.EnteredDescription -> {
            }
            is AddEditTransactionEvent.EnteredAmount -> {
            }
            is AddEditTransactionEvent.ExpenseSelected -> {
                isExpenseSelected = true
            }
            is AddEditTransactionEvent.IncomeSelected -> {
                isExpenseSelected = false
            }
            is AddEditTransactionEvent.DeleteTransaction -> {
            }
            is AddEditTransactionEvent.ShowDatePicker -> {
                _shouldShowDatePicker.value = true
            }
        }
    }

}