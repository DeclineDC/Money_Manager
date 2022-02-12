package com.decline.moneymanagerv2.app_features.domain.use_case

import com.decline.moneymanagerv2.app_features.domain.model.Transaction
import com.decline.moneymanagerv2.app_features.domain.repository.MoneyManagerRepository
import com.decline.moneymanagerv2.app_features.domain.util.InvalidTransactionException
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetIncomeByMonth(
    private val repository: MoneyManagerRepository
) {

    operator fun invoke(localDate: LocalDate): Flow<Double>? {
        return repository.getIncomeByMonth(localDate)

    }
}