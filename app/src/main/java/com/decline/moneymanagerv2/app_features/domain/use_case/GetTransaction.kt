package com.decline.moneymanagerv2.app_features.domain.use_case

import com.decline.moneymanagerv2.app_features.domain.model.Transaction
import com.decline.moneymanagerv2.app_features.domain.repository.MoneyManagerRepository
import com.decline.moneymanagerv2.app_features.domain.util.InvalidTransactionException

class GetTransaction(
    private val repository: MoneyManagerRepository
) {

    suspend operator fun invoke(id: Int): Transaction? {
        return repository.getTransactionById(id)
    }
}