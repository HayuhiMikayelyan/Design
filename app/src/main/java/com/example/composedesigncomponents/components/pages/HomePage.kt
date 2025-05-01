package com.example.composedesigncomponents.components.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composedesigncomponents.R
import com.example.composedesigncomponents.components.backgrounds.MainTopBackground
import com.example.composedesigncomponents.components.cards.BottomCard
import com.example.composedesigncomponents.components.cards.InformationCard
import com.example.composedesigncomponents.components.cards.MainActionsCard
import com.example.composedesigncomponents.components.icons.MonthNavigationButton
import com.example.composedesigncomponents.components.icons.RoundIcon
import com.example.composedesigncomponents.components.navigation.Screen
import com.example.composedesigncomponents.ui.theme.BrandPrimary100
import com.example.composedesigncomponents.ui.theme.BrandPrimary800
import com.example.composedesigncomponents.ui.theme.BrandSecondary25
import com.example.composedesigncomponents.ui.theme.BrandSecondary700
import com.example.composedesigncomponents.ui.theme.BrandSecondary800
import com.example.composedesigncomponents.ui.theme.BrandSecondaryBlue100
import com.example.composedesigncomponents.ui.theme.BrandSecondaryBlue800
import com.example.composedesigncomponents.ui.theme.Neutral0
import com.example.composedesigncomponents.ui.theme.Neutral800

@Composable
fun HomePage(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BrandSecondary800),
        ) {
            MainTopBackground()

            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                Box(modifier = Modifier.padding(top = 48.dp, start = 16.dp, end = 16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RoundIcon(
                            R.drawable.notifications,
                            "Notifications",
                            BrandSecondary25,
                            BrandSecondary700, onClick = {
                                navController.navigate(Screen.Notifications.route) {
                                    popUpTo(Screen.Home.route) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            })

                        RoundIcon(
                            R.drawable.settings,
                            "Settings",
                            BrandSecondary25,
                            BrandSecondary700, onClick = {
                                navController.navigate(Screen.Settings.route) {
                                    popUpTo(Screen.Home.route) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            })
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 32.dp, end = 32.dp, top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        MonthNavigationButton(
                            icon = R.drawable.previous,
                            text = "Previous",
                            isActive = true
                        )
                        Image(
                            painter = painterResource(id = R.drawable.progress),
                            contentDescription = null,
                            modifier = Modifier.size(220.dp)
                        )
                        MonthNavigationButton(
                            icon = R.drawable.next,
                            text = "Next",
                            isActive = false
                        )
                    }
                }

                InformationCard(
                    nextReportPeriod = "Dec 2024-Jan 2025", mustBeSubmitted = "Feb 2025",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 12.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 14.dp, start = 16.dp, end = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    MainActionsCard(
                        BrandSecondaryBlue100,
                        R.drawable.reporting,
                        "Reporting",
                        BrandSecondaryBlue800
                    )
                    MainActionsCard(
                        Neutral0,
                        R.drawable.monthly_report,
                        "Monthly report",
                        Neutral800
                    )
                    MainActionsCard(
                        BrandPrimary100,
                        R.drawable.final_report,
                        "Final report",
                        BrandPrimary800
                    )
                }

                BottomCard(title = "Last reporting", modifier = Modifier.padding(top = 16.dp))
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    HomePage(navController = rememberNavController())
}