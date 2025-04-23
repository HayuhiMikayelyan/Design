package com.example.composedesigncomponents.components.icons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedesigncomponents.R
import com.example.composedesigncomponents.ui.theme.BrandSecondary25
import com.example.composedesigncomponents.ui.theme.BrandSecondary700

@Composable
fun RoundIcon(
    icon: Int,
    text: String,
    tint: Color,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = text, tint = tint)
    }
}

@Preview
@Composable
private fun Preview() {
    RoundIcon(R.drawable.notifications, "Notifications", BrandSecondary25, BrandSecondary700)
}