package com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen

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
import java.time.LocalDate
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

    var currentTransactionId: Int? = null
    var currentTransaction: Transaction? = null

    init {
        savedStateHandle.get<Int>("transactionId")?.let { transactionId ->
            if (transactionId != -1) {
                viewModelScope.launch {
                    moneyManagerUseCases.getTransaction(transactionId)?.also { transaction ->
                        currentTransactionId = transaction.id
                        currentTransaction = transaction
                        state = state.copy(
                            description = transaction.description,
                            amount = transaction.amount.toString(),
                            isExpenseSelected = transaction.isExpense,
                            date = LocalDate.of(
                                transaction.year,
                                transaction.month,
                                transaction.dayOfMonth
                            )
                        )

                    }
                }

            }
        }
    }

    fun onEvent(event: AddEditTransactionEvent) {
        when (event) {
            is AddEditTransactionEvent.OnDescriptionChange -> {
                state = state.copy(
                    description = event.value
                )
            }
            is AddEditTransactionEvent.OnAmountChange -> {
                state = state.copy(
                    amount = event.value
                )
            }
            is AddEditTransactionEvent.OnExpenseSelected -> {
                state = state.copy(
                    isExpenseSelected = true
                )
            }
            is AddEditTransactionEvent.OnIncomeSelected -> {
                state = state.copy(
                    isExpenseSelected = false
                )
            }
            is AddEditTransactionEvent.OnDateChange -> {
                state = state.copy(
                    date = event.localDate
                )
            }
            is AddEditTransactionEvent.OnDeleteClick -> {
                viewModelScope.launch {
                    moneyManagerUseCases.deleteTransaction(event.transaction)
                    _eventFlow.emit(UiEvent.OnDeleteClick)
                }
            }
            is AddEditTransactionEvent.OnBackClick -> {
                viewModelScope.launch {
                    _eventFlow.emit(UiEvent.OnBackClick)
                }
            }
            is AddEditTransactionEvent.OnSaveTransaction -> {
                viewModelScope.launch {
                    try {
                        moneyManagerUseCases.addTransaction(
                            Transaction(
                                description = state.description,
                                amount = state.amount.toDoubleOrNull(),
                                dayOfMonth = state.date.dayOfMonth,
                                month = state.date.monthValue,
                                year = state.date.year,
                                isExpense = state.isExpenseSelected,
                                id = currentTransactionId
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