package com.decline.moneymanagerv2.app_features.presentation.balance_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.decline.moneymanagerv2.app_features.domain.model.Transaction
import com.decline.moneymanagerv2.app_features.domain.use_case.MoneyManagerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class BalanceViewModel @Inject constructor(
    private val moneyManagerUseCases: MoneyManagerUseCases
) : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    val transactions = listOf<Transaction>(
        Transaction(
            description = "Test",
            amount = 10.0,
            year = LocalDate.now().year,
            month = LocalDate.now().monthValue,
            dayOfMonth = LocalDate.now().dayOfMonth,
            isExpense = false
        ),
        Transaction(
            description = "Test",
            amount = 10.0,
            year = LocalDate.now().year,
            month = LocalDate.now().monthValue,
            dayOfMonth = LocalDate.now().dayOfMonth,
            isExpense = true
        ),
        Transaction(
            description = "Test",
            amount = 10.0,
            year = LocalDate.now().year,
            month = LocalDate.now().monthValue,
            dayOfMonth = LocalDate.now().dayOfMonth,
            isExpense = false
        ),
        Transaction(
            description = "Test",
            amount = 10.0,
            year = LocalDate.now().year,
            month = LocalDate.now().monthValue,
            dayOfMonth = LocalDate.now().dayOfMonth,
            isExpense = true
        ),
        Transaction(
            description = "Test",
            amount = 10.0,
            year = LocalDate.now().year,
            month = LocalDate.now().monthValue,
            dayOfMonth = LocalDate.now().dayOfMonth,
            isExpense = false
        )
    )
}