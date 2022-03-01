package com.decline.moneymanagerv2.app_features.domain.use_case


import com.decline.moneymanagerv2.app_features.domain.model.Transaction
import com.decline.moneymanagerv2.app_features.domain.repository.MoneyManagerRepository
import com.decline.moneymanagerv2.app_features.domain.util.InvalidTransactionException

class AddTransaction(
    private val repository: MoneyManagerRepository
) {

    @Throws(InvalidTransactionException::class)

    suspend operator fun invoke(transaction: Transaction) {
        if (transaction.description.isBlank() && (transaction.amount == null || transaction.amount == 0.0)) {
            throw InvalidTransactionException("Enter a description and amount")
        }
        if (transaction.description.isBlank()) {
            throw InvalidTransactionException("Enter a description")
        }
        if (transaction.amount == null || transaction.amount == 0.0) {
            throw InvalidTransactionException("Invalid amount")
        }

        repository.insertTransaction(transaction)
    }
}