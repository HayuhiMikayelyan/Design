package com.example.composedesigncomponents.components.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedesigncomponents.R
import com.example.composedesigncomponents.components.backgrounds.MainTopBackground
import com.example.composedesigncomponents.components.cards.BottomCard
import com.example.composedesigncomponents.components.cards.InformationCard
import com.example.composedesigncomponents.components.cards.MainActionsCard
import com.example.composedesigncomponents.components.icons.MonthNavigationButton
import com.example.composedesigncomponents.components.icons.RoundIcon
import com.example.composedesigncomponents.components.navigation.BottomNavigationBar
import com.example.composedesigncomponents.ui.theme.BrandPrimary100
import com.example.composedesigncomponents.ui.theme.BrandPrimary800
import com.example.composedesigncomponents.ui.theme.BrandSecondary800
import com.example.composedesigncomponents.ui.theme.BrandSecondaryBlue100
import com.example.composedesigncomponents.ui.theme.BrandSecondaryBlue800
import com.example.composedesigncomponents.ui.theme.Gray
import com.example.composedesigncomponents.ui.theme.Neutral0
import com.example.composedesigncomponents.ui.theme.Neutral800
import com.example.composedesigncomponents.ui.theme.Primary500

@Composable
fun MainPage() {

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
                        RoundIcon(R.drawable.notifications, "Notifications")
                        RoundIcon(R.drawable.settings, "Settings")
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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(170.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Gray.copy(alpha = 0.9f)),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 16.dp, end = 16.dp, bottom = 64.dp)
        ) {
            BottomNavigationBar()
            FloatingActionButton(
                onClick = {},
                containerColor = Primary500,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .size(56.dp)
                    .offset(y = (-34).dp)
                    .clip(CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = "Add"
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    MainPage()
}