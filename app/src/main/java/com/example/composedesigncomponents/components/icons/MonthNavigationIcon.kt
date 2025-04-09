package com.example.composedesigncomponents.components.icons

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composedesigncomponents.R


@Composable
fun MonthNavigationButton(
    icon: Int,
    text: String,
    isActive: Boolean
) {
    Image(
        painter = painterResource(id = icon),
        contentDescription = text,
        modifier = if (isActive) Modifier else Modifier.graphicsLayer(alpha = 0.4f)
    )
}

@Preview
@Composable
private fun Preview() {
    MonthNavigationButton(icon = R.drawable.previous, text = "Previous", isActive = true)
}