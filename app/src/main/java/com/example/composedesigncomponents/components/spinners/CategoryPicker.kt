package com.example.composedesigncomponents.components.spinners

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedesigncomponents.R
import com.example.composedesigncomponents.ui.theme.BackgroundMain2
import com.example.composedesigncomponents.ui.theme.IconPlaceholder
import com.example.composedesigncomponents.ui.theme.LocalInterFontFamily
import com.example.composedesigncomponents.ui.theme.StrokeStrong
import com.example.composedesigncomponents.ui.theme.TextPlaceholder
import com.example.composedesigncomponents.ui.theme.TextSubtitle

@Composable
fun CategoryPicker(
    modifier: Modifier = Modifier,
    label: String,
    hint: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = StrokeStrong,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
            .background(BackgroundMain2)
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = label,
                fontSize = 14.sp,
                fontFamily = LocalInterFontFamily,
                fontWeight = FontWeight.Normal,
                color = TextSubtitle
            )
            Text(
                text = hint,
                fontSize = 16.sp,
                fontFamily = LocalInterFontFamily,
                fontWeight = FontWeight.Normal,
                color = TextPlaceholder,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.expand),
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = IconPlaceholder
        )
    }
}

@Preview
@Composable
private fun Preview() {
    CategoryPicker(label = "Expense category", hint = "Select one")
}