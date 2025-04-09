package com.example.composedesigncomponents.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedesigncomponents.ui.theme.BrandSecondary200
import com.example.composedesigncomponents.ui.theme.BrandSecondary50
import com.example.composedesigncomponents.ui.theme.BrandSecondary900
import com.example.composedesigncomponents.ui.theme.LocalInterFontFamily

@Composable
fun InformationCard(
    nextReportPeriod: String,
    mustBeSubmitted: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(BrandSecondary900)
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {

        Row {
            Text(
                text = "Next report period:",
                fontSize = 16.sp,
                fontFamily = LocalInterFontFamily,
                fontWeight = FontWeight.Normal,
                color = BrandSecondary200,
                modifier = Modifier.padding(end = 8.dp)
            )

            Text(
                text = nextReportPeriod,
                fontSize = 16.sp,
                fontFamily = LocalInterFontFamily,
                fontWeight = FontWeight.Bold,
                color = BrandSecondary50
            )
        }

        Row {
            Text(
                text = "Must be submitted on:",
                fontSize = 16.sp,
                fontFamily = LocalInterFontFamily,
                fontWeight = FontWeight.Normal,
                color = BrandSecondary200,
                modifier = Modifier.padding(end = 8.dp)
            )

            Text(
                text = mustBeSubmitted,
                fontSize = 16.sp,
                fontFamily = LocalInterFontFamily,
                fontWeight = FontWeight.Bold,
                color = BrandSecondary50
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    InformationCard(
        nextReportPeriod = "Dec 2024-Jan 2025", mustBeSubmitted = "Feb 2025",
        modifier = Modifier
            .fillMaxWidth()
    )
}