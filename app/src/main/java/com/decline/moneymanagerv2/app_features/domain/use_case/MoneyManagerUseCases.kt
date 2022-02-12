package com.decline.moneymanagerv2.app_features.domain.use_case

data class MoneyManagerUseCases(
    val addTransaction: AddTransaction,
    val deleteTransaction: DeleteTransaction,
    val getTransactions: GetTransactions,
    val getTransaction: GetTransaction,
    val getTransactionsByMonth: GetTransactionsByMonth,
    val getBalanceByMonth: GetBalanceByMonth,
    val getExpenseByMonth: GetExpenseByMonth,
    val getIncomeByMonth: GetIncomeByMonth,
)