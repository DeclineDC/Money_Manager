package com.decline.moneymanagerv2.app_features.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen.AddEditTransactionScreen
import com.decline.moneymanagerv2.app_features.presentation.balance_screen.BalanceScreen
import com.decline.moneymanagerv2.app_features.presentation.util.Screen
import com.decline.moneymanagerv2.ui.theme.MoneyManagerV2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoneyManagerV2Theme {

                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.BalanceScreen.route
                    ) {
                        composable(route = Screen.BalanceScreen.route) {
                            BalanceScreen(navController = navController)
                        }
                        composable(
                            route = Screen.AddEditTransactionScreen.route +
                                    "?transactionId={transactionId}",
                            arguments = listOf(
                                navArgument(
                                    name = "transactionId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                            AddEditTransactionScreen(navController = navController)
                        }
                    }

                }
            }
        }
    }
}