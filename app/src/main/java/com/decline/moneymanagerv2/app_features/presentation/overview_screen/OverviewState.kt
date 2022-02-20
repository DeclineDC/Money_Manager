package com.decline.moneymanagerv2.app_features.presentation.overview_screen

import com.decline.moneymanagerv2.app_features.domain.model.Transaction
import java.time.LocalDate

data class OverviewState (
    val transactions: List<Transaction> = emptyList(),
    val income: Double = 0.0,
    val expense: Double = 0.0,
    val balance: Double = 0.0,
    val date: LocalDate = LocalDate.now()
)