package com.decline.moneymanagerv2.app_features.domain.use_case


import com.decline.moneymanagerv2.app_features.domain.model.Transaction
import com.decline.moneymanagerv2.app_features.domain.repository.MoneyManagerRepository
import com.decline.moneymanagerv2.app_features.domain.util.InvalidTransactionException

class AddTransaction(
    private val repository: MoneyManagerRepository
) {

    @Throws(InvalidTransactionException::class, NumberFormatException::class)

    suspend operator fun invoke(transaction: Transaction) {
        if (transaction.description.isBlank()) {
            throw InvalidTransactionException("The description can't be empty")
        }
        if (transaction.amount.equals(0.0)) {
            throw InvalidTransactionException("The amount can't be empty")
        }
        if (transaction.amount.isNaN()) {
            throw InvalidTransactionException("Invalid Amount")
        }
        repository.insertTransaction(transaction)
    }
}