package com.decline.moneymanagerv2.app_features.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Transaction(
    val description: String,
    val amount: Double,
    val dayOfMonth: Int,
    val month: Int,
    val year: Int,
    val isExpense: Boolean,
    @PrimaryKey val id: Int? = null
)
