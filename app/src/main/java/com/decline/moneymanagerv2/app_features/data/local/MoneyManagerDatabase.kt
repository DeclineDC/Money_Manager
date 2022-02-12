package com.decline.moneymanagerv2.app_features.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.decline.moneymanagerv2.app_features.domain.model.Transaction


@Database(
    entities = [Transaction::class],
    version = 1
)
abstract class MoneyManagerDatabase() : RoomDatabase() {

    abstract val moneyManagerDao: MoneyManagerDao
}