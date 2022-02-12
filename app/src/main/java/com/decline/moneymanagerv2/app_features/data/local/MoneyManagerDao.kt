package com.decline.moneymanagerv2.app_features.data.local


import androidx.room.*
import com.decline.moneymanagerv2.app_features.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface MoneyManagerDao {

    @Query("SELECT * FROM `transaction` WHERE id = :id")
    suspend fun getTransactionById(id: Int): Transaction?

    @Query("SELECT * FROM `transaction`")
    fun getTransactions(): Flow<List<Transaction>>

    @Query("SELECT * FROM `transaction` WHERE month = :month AND year = :year")
    fun getTransactionsByMonth(month: Int, year: Int): Flow<List<Transaction>>

    @Query(
        """
        SELECT SUM(case when isExpense = 0 then amount
                        when isExpense = 1 then -amount
                end)
                as BALANCE FROM `transaction` WHERE month = :month AND year = :year 
             """
    )
    fun getBalanceByMonth(month: Int, year: Int): Flow<Double>?

    @Query("SELECT SUM (amount) FROM `transaction` WHERE isExpense = 1 AND month = :month AND year = :year")
    fun getExpenseByMonth(month: Int, year: Int): Flow<Double>?

    @Query("SELECT SUM (amount) FROM `transaction` WHERE isExpense = 0 AND month = :month AND year = :year")
    fun getIncomeByMonth(month: Int, year: Int): Flow<Double>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)

}