package com.example.composedesigncomponents.components.progress

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedesigncomponents.R
import com.example.composedesigncomponents.ui.theme.LocalInterFontFamily
import com.example.composedesigncomponents.ui.theme.TextIncomeLight

@Composable
fun IncomeExpenseProgress(
    modifier: Modifier = Modifier,
    incomePercentage: Float,
    expensePercentage: Float,
    amount: String,
    textColor: Color,
    date: String
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.progress_background),
            contentDescription = null,
            modifier = Modifier.size(220.dp)
        )
        Text(
            text = amount,
            fontSize = 20.sp,
            fontFamily = LocalInterFontFamily,
            fontWeight = FontWeight.ExtraBold,
            color = textColor,
            modifier = Modifier.align(Alignment.Center)
        )

        /*Box(
            modifier = Modifier
                .size(200.dp)
                .clip(ProgressShape(arcPercentage = 0.35f, direction = -1f))
                .background(
                    Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF31C489),
                        Color(0xFF71E0AC)
                    )
                ))
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(ProgressShape(arcPercentage = 0.65f))
                .background(Color(0xFF6A1B9A))
        )*/
    }
}


@Preview
@Composable
private fun Preview() {
    IncomeExpenseProgress(
        incomePercentage = 0.7f,
        expensePercentage = 0.3f,
        amount = "₪10,156",
        textColor = TextIncomeLight,
        date = "Jan 2024"
    )
}