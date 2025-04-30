package com.example.composedesigncomponents.components.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Reports : Screen("reports")
    data object Analytics : Screen("analytics")
    data object Account : Screen("account")
    data object AddIncome : Screen("add_income")
    data object AddExpense : Screen("add_expanse")
    data object AddDocument : Screen("add_document")
}