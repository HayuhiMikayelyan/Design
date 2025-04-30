package com.example.composedesigncomponents.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composedesigncomponents.components.pages.AddDocumentPage
import com.example.composedesigncomponents.components.pages.AddExpensePage
import com.example.composedesigncomponents.components.pages.AddIncomePage
import com.example.composedesigncomponents.components.pages.MainPage

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            MainPage(navController)
        }

        composable(Screen.AddIncome.route) {
            AddIncomePage(navController)
        }

        composable(Screen.AddExpense.route) {
            AddExpensePage(navController)
        }

        composable(Screen.AddDocument.route) {
            AddDocumentPage(navController)
        }

    }
}