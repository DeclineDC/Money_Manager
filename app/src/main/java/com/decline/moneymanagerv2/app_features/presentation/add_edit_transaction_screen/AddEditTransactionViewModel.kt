package com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.decline.moneymanagerv2.app_features.domain.use_case.MoneyManagerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditTransactionViewModel @Inject constructor(
    private val moneyManagerUseCases: MoneyManagerUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

}