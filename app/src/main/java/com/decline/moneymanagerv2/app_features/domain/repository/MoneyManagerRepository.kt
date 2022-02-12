package com.decline.moneymanagerv2.app_features.domain.repository

import com.decline.moneymanagerv2.app_features.domain.model.Transaction
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface MoneyManagerRepository {

    suspend fun insertTransaction(transaction: Transaction)

    suspend fun deleteTransaction(transaction: Transaction)

    fun getBalanceByMonth(localDate: LocalDate): Flow<Double>?

    fun getExpenseByMonth(localDate: LocalDate): Flow<Double>?

    fun getIncomeByMonth(localDate: LocalDate): Flow<Double>?

    fun getTransactions(): Flow<List<Transaction>>

    fun getTransactionsByMonth(localDate: LocalDate): Flow<List<Transaction>>

    suspend fun getTransactionById(id: Int): Transaction?
}