package com.example.composedesigncomponents.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedesigncomponents.ui.theme.LocalInterFontFamily
import com.example.composedesigncomponents.ui.theme.Neutral0
import com.example.composedesigncomponents.ui.theme.NeutralDarkDarkest


@Composable
fun BottomCard(
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(Neutral0)
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontFamily = LocalInterFontFamily,
            fontWeight = FontWeight.Bold,
            color = NeutralDarkDarkest
        )

        LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
            item {
                ReportItemCard(
                    0, "Dec 04 2024", "₪14,000", ".00",
                    "Pension Business income Income category 1 income"
                )

                ReportItemCard(
                    1, "Jan 17 2025", "₪102", ".99",
                    "Pension Business income Income category 1 income"
                )

                ReportItemCard(
                    2, "Dec 04 2025",
                    text = "Pension Business income Income category 1 income"
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    BottomCard(title = "Last reporting", modifier = Modifier)
}