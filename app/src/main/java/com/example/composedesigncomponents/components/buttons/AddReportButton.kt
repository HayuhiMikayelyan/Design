package com.example.composedesigncomponents.components.buttons

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedesigncomponents.R
import com.example.composedesigncomponents.ui.theme.Neutral900
import com.example.composedesigncomponents.ui.theme.Primary500

@Composable
fun AddReportButton() {
    FloatingActionButton(
        modifier = Modifier
            .size(56.dp)
            .clip(CircleShape),
        containerColor = Primary500,
        onClick = {

        }) {
        Icon(
            painter = painterResource(id = R.drawable.add), contentDescription = "Add",
            tint = Neutral900
        )
    }
}

@Preview
@Composable
private fun Preview() {
    AddReportButton()
}