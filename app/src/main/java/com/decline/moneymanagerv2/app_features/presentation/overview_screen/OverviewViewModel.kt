package com.decline.moneymanagerv2.app_features.presentation.overview_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decline.moneymanagerv2.app_features.domain.use_case.MoneyManagerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(
    private val moneyManagerUseCases: MoneyManagerUseCases
) : ViewModel() {

    var state by mutableStateOf(OverviewState())
        private set

    init {
        getDataByMonth(state.date)
    }

    private fun getDataByMonth(date: LocalDate) {
        moneyManagerUseCases.getTransactionsByMonth(date)
            .onEach { transactions ->
                state = state.copy(
                    transactions = transactions
                )
            }
            .launchIn(viewModelScope)

        viewModelScope.launch {
            moneyManagerUseCases.getExpenseByMonth(date)
                ?.let {
                    it.filterNotNull().collect { expense ->
                        state = state.copy(
                            expense = expense
                        )
                    }
                }
        }
        viewModelScope.launch {
            moneyManagerUseCases.getIncomeByMonth(date)
                ?.let {
                    it.filterNotNull().collect { income ->
                        state = state.copy(
                            income = income
                        )
                    }
                }
        }
        viewModelScope.launch {
            moneyManagerUseCases.getBalanceByMonth(date)
                ?.let {
                    it.filterNotNull().collect { balance ->
                        state = state.copy(
                            balance = balance
                        )
                    }
                }
        }
    }

    fun onEvent(event: OverviewEvent) {
        when (event) {
            is OverviewEvent.PreviousDate -> {
                state = state.copy(
                    date = state.date.minusMonths(1)
                )
                getDataByMonth(state.date)
            }
            is OverviewEvent.NextDate -> {
                state = state.copy(
                    date = state.date.plusMonths(1)
                )
                getDataByMonth(state.date)
            }
        }

    }

}