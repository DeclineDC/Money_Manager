package com.decline.moneymanagerv2.app_features.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.decline.moneymanagerv2.app_features.data.local.MoneyManagerDao
import com.decline.moneymanagerv2.app_features.domain.model.Transaction
import com.decline.moneymanagerv2.app_features.domain.repository.MoneyManagerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
class MoneyManagerRepositoryImpl(private val dao: MoneyManagerDao) : MoneyManagerRepository {

    override suspend fun insertTransaction(transaction: Transaction) {
        return dao.insertTransaction(transaction)
    }

    override suspend fun deleteTransaction(transaction: Transaction) {
        return dao.deleteTransaction(transaction)
    }


    override fun getBalanceByMonth(localDate: LocalDate): Flow<Double>? {
        return dao.getBalanceByMonth(
            month = localDate.monthValue,
            year = localDate.year
        )
    }

    override fun getExpenseByMonth(localDate: LocalDate): Flow<Double>? {
        return dao.getExpenseByMonth(
            month = localDate.monthValue,
            year = localDate.year
        )
    }

    override fun getIncomeByMonth(localDate: LocalDate): Flow<Double>? {
        return dao.getIncomeByMonth(
            month = localDate.monthValue,
            year = localDate.year
        )
    }

    override fun getTransactions(): Flow<List<Transaction>> {
        return dao.getTransactions()
    }

    override fun getTransactionsByMonth(localDate: LocalDate): Flow<List<Transaction>> {
        return dao.getTransactionsByMonth(
            month = localDate.monthValue,
            year = localDate.year
        )
    }

    override suspend fun getTransactionById(id: Int): Transaction? {
        return dao.getTransactionById(id)
    }
}