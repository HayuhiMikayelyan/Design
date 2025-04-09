package com.example.composedesigncomponents.components.icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedesigncomponents.R
import com.example.composedesigncomponents.ui.theme.BrandSecondary700

@Composable
fun RoundIcon(
    icon: Int,
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .clip(CircleShape)
            .background(BrandSecondary700),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = icon), contentDescription = text)
    }
}

@Preview
@Composable
private fun Preview() {
    RoundIcon(R.drawable.notifications, "Notifications")
}