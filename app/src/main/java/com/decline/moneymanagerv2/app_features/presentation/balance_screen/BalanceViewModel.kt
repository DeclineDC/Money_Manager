package com.decline.moneymanagerv2.app_features.presentation.balance_screen

import androidx.lifecycle.ViewModel
import com.decline.moneymanagerv2.app_features.domain.use_case.MoneyManagerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BalanceViewModel @Inject constructor(
    private val moneyManagerUseCases: MoneyManagerUseCases
) : ViewModel() {

}