package com.decline.moneymanagerv2.app_features.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.decline.moneymanagerv2.app_features.presentation.add_edit_transaction_screen.AddEditTransactionScreen
import com.decline.moneymanagerv2.app_features.presentation.balance_screen.BalanceScreen
import com.decline.moneymanagerv2.app_features.presentation.util.Screen
import com.decline.moneymanagerv2.ui.theme.LocalSpacing
import com.decline.moneymanagerv2.ui.theme.MoneyManagerV2Theme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoneyManagerV2Theme {

                val navController = rememberAnimatedNavController()
                val spacing = LocalSpacing.current

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = Screen.BalanceScreen.route
                    ) {
                        composable(
                            route = Screen.BalanceScreen.route,
                        ) {
                            BalanceScreen(navController = navController)
                        }
                        composable(
                            route = Screen.AddEditTransactionScreen.route +
                                    "?transactionId={transactionId}",

                            /*arguments = listOf(
                                navArgument(
                                    name = "transactionId"
                                ) {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )*/

                        ) {
                            AddEditTransactionScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}