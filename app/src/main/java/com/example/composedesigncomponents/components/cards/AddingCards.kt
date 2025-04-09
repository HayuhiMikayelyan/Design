package com.example.composedesigncomponents.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedesigncomponents.R
import com.example.composedesigncomponents.ui.theme.Green200
import com.example.composedesigncomponents.ui.theme.Green900
import com.example.composedesigncomponents.ui.theme.LocalInterFontFamily

@Composable
fun AddCard(
    icon: Int,
    text: String,
    backgroundColor: Color,
    foregroundColor: Color
) {
    Column(
        modifier = Modifier
            .size(100.dp, 80.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = text
        )
        Text(
            text = text,
            fontSize = 14.sp,
            fontFamily = LocalInterFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = foregroundColor,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun Preview() {
    AddCard(R.drawable.income, "Income", Green200, Green900)
}