package com.example.composedesigncomponents.components.icons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedesigncomponents.R
import com.example.composedesigncomponents.ui.theme.ButtonPlain
import com.example.composedesigncomponents.ui.theme.IconRegular
import com.example.composedesigncomponents.ui.theme.LocalInterFontFamily
import com.example.composedesigncomponents.ui.theme.TextSubtitle

@Composable
fun RectangleIcon(
    icon: Int,
    text: String? = null,
    tint: Color,
    textColor: Color,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .padding(horizontal = 24.dp, vertical = 12.dp),
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = text, tint = tint)
        text?.let {
            Text(
                text = it,
                fontSize = 16.sp,
                fontFamily = LocalInterFontFamily,
                fontWeight = FontWeight.Medium,
                color = textColor,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    RectangleIcon(R.drawable.camera, "Photo", IconRegular, TextSubtitle, ButtonPlain)
}