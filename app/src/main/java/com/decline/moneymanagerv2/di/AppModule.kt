package com.decline.moneymanagerv2.di

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Room
import com.decline.moneymanagerv2.app_features.data.local.MoneyManagerDatabase
import com.decline.moneymanagerv2.app_features.data.repository.MoneyManagerRepositoryImpl
import com.decline.moneymanagerv2.app_features.data.util.Constants.DATABASE_NAME
import com.decline.moneymanagerv2.app_features.domain.repository.MoneyManagerRepository
import com.decline.moneymanagerv2.app_features.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoneyManagerDatabase(app: Application): MoneyManagerDatabase {
        return Room.databaseBuilder(
            app,
            MoneyManagerDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Provides
    @Singleton
    fun provideMoneyManagerRepository(db: MoneyManagerDatabase): MoneyManagerRepository {
        return MoneyManagerRepositoryImpl(db.moneyManagerDao)
    }

    @Provides
    @Singleton
    fun provideMoneyManagerUseCases(repository: MoneyManagerRepository): MoneyManagerUseCases {
        return MoneyManagerUseCases(
            addTransaction = AddTransaction(repository),
            deleteTransaction = DeleteTransaction(repository),
            getTransaction = GetTransaction(repository),
            getTransactions = GetTransactions(repository),
            getTransactionsByMonth = GetTransactionsByMonth(repository),
            getBalanceByMonth = GetBalanceByMonth(repository),
            getExpenseByMonth = GetExpenseByMonth(repository),
            getIncomeByMonth = GetIncomeByMonth(repository),
        )
    }
}