package com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decline.moneymanagerv2.app_features.domain.model.Transaction
import com.decline.moneymanagerv2.app_features.domain.use_case.MoneyManagerUseCases
import com.decline.moneymanagerv2.app_features.domain.util.InvalidTransactionException
import com.decline.moneymanagerv2.app_features.presentation.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditTransactionViewModel @Inject constructor(
    private val moneyManagerUseCases: MoneyManagerUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    var state by mutableStateOf(AddEditTransactionState())
        private set

    private val _shouldShowDatePicker = mutableStateOf(false)
    val shouldShowDatePicker: State<Boolean> = _shouldShowDatePicker


    fun onEvent(event: AddEditTransactionEvent) {
        when (event) {
            is AddEditTransactionEvent.EnteredDescription -> {
                state = state.copy(
                    description = event.value
                )
            }
            is AddEditTransactionEvent.EnteredAmount -> {
                state = state.copy(
                    amount = event.value
                )
            }
            is AddEditTransactionEvent.ExpenseSelected -> {
                state = state.copy(
                    isExpenseSelected = true
                )
            }
            is AddEditTransactionEvent.IncomeSelected -> {
                state = state.copy(
                    isExpenseSelected = false
                )
            }
            is AddEditTransactionEvent.DeleteTransaction -> {
                viewModelScope.launch {
                    moneyManagerUseCases.deleteTransaction(event.transaction)
                }
            }
            is AddEditTransactionEvent.ShowDatePicker -> {
                _shouldShowDatePicker.value = true
            }
            is AddEditTransactionEvent.SaveTransaction -> {
                viewModelScope.launch {
                    try {
                        moneyManagerUseCases.addTransaction(
                            Transaction(
                                description = state.description,
                                amount = state.amount.toDouble(),
                                dayOfMonth = state.date.dayOfMonth,
                                month = state.date.monthValue,
                                year = state.date.year,
                                isExpense = state.isExpenseSelected
                            )
                        )
                        _eventFlow.emit(UiEvent.SaveTransaction)
                    } catch (e: InvalidTransactionException) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackBar(
                                message = e.message ?: "Couldn't save transaction"
                            )
                        )
                    } catch (e: NumberFormatException) {
                        UiEvent.ShowSnackBar(
                            message = e.message ?: "Couldn't save transaction"
                        )
                    }

                }
            }

        }
    }

}