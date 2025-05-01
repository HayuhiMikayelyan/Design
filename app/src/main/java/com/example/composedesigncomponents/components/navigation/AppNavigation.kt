package com.example.composedesigncomponents.components.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composedesigncomponents.components.pages.AccountPage
import com.example.composedesigncomponents.components.pages.AddDocumentPage
import com.example.composedesigncomponents.components.pages.AddExpensePage
import com.example.composedesigncomponents.components.pages.AddIncomePage
import com.example.composedesigncomponents.components.pages.AnalyticsPage
import com.example.composedesigncomponents.components.pages.HomePage
import com.example.composedesigncomponents.components.pages.NotificationsPage
import com.example.composedesigncomponents.components.pages.ReportsPage

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val tabsWithBar = setOf(
        Screen.Home.route, Screen.Reports.route, Screen.Analytics.route, Screen.Account.route
    )
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    val showBottomBar = currentRoute in tabsWithBar
    val bottomBarHeight = 64.dp

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = if (showBottomBar) bottomBarHeight else 0.dp)
        ) {

            composable(Screen.Home.route) { HomePage(navController) }
            composable(Screen.AddIncome.route) { AddIncomePage(navController) }
            composable(Screen.AddExpense.route) { AddExpensePage(navController) }
            composable(Screen.AddDocument.route) { AddDocumentPage(navController) }
            composable(Screen.Reports.route) { ReportsPage(navController) }
            composable(Screen.Analytics.route) { AnalyticsPage(navController) }
            composable(Screen.Account.route) { AccountPage(navController) }
            composable(Screen.Notifications.route) { NotificationsPage(navController) }
            composable(Screen.Notifications.route) { NotificationsPage(navController) }
        }

        if (showBottomBar) {
            BottomNavigationBar(
                navController = navController,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(start = 16.dp, end = 16.dp, bottom = 64.dp)
            )
        }
    }
}

