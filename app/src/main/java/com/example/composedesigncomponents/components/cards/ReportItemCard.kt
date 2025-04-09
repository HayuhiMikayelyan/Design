package com.example.composedesigncomponents.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedesigncomponents.ui.theme.BrandSecondary700
import com.example.composedesigncomponents.ui.theme.BrandSecondaryBlue100
import com.example.composedesigncomponents.ui.theme.BrandSecondaryBlue50
import com.example.composedesigncomponents.ui.theme.Green100
import com.example.composedesigncomponents.ui.theme.Green50
import com.example.composedesigncomponents.ui.theme.Green700
import com.example.composedesigncomponents.ui.theme.Green800
import com.example.composedesigncomponents.ui.theme.LocalInterFontFamily
import com.example.composedesigncomponents.ui.theme.Neutral800
import com.example.composedesigncomponents.ui.theme.Purple100
import com.example.composedesigncomponents.ui.theme.Purple25
import com.example.composedesigncomponents.ui.theme.Purple500
import com.example.composedesigncomponents.ui.theme.Purple700

@Composable
fun ReportItemCard(
    type: Int,
    date: String,
    amount: String = "",
    coin: String = "",
    text: String
) {
    val colors = listOf(
        listOf(Green800, Green100, Green50, Green700),
        listOf(Purple700, Purple100, Purple25, Purple500),
        listOf(BrandSecondary700, BrandSecondaryBlue100, BrandSecondaryBlue50)
    )

    val title = listOf("Income", "Expense", "Document")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(colors[type][2])
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 16.dp, bottomEnd = 8.dp))
                    .background(colors[type][1])
                    .padding(start = 12.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title[type],
                    fontSize = 14.sp,
                    fontFamily = LocalInterFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = colors[type][0],
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, end = 4.dp)
                )

                Text(
                    text = date,
                    fontSize = 14.sp,
                    fontFamily = LocalInterFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = colors[type][0]
                )
            }

            if (type != 2) {
                Row(
                    modifier = Modifier.padding(end = 16.dp, top = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = amount,
                        fontSize = 20.sp,
                        fontFamily = LocalInterFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = colors[type][3],
                        modifier = Modifier.padding(4.dp)
                    )

                    Text(
                        text = coin,
                        fontSize = 14.sp,
                        fontFamily = LocalInterFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = colors[type][3]
                    )
                }
            }
        }

        Text(
            text = text,
            fontSize = 16.sp,
            fontFamily = LocalInterFontFamily,
            fontWeight = FontWeight.Medium,
            color = Neutral800,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        )
    }
}

@Preview
@Composable
private fun Preview() {
    ReportItemCard(
        0, "Dec 04 2024", "₪14,000", ".00",
        "Pension Business income Income category 1 income"
    )
}