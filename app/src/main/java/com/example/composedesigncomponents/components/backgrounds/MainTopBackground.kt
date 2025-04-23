package com.example.composedesigncomponents.components.backgrounds

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composedesigncomponents.R

@Composable
fun MainTopBackground() {
    Image(
        painter = painterResource(id = R.drawable.main_background),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Preview
@Composable
private fun Preview() {
    MainTopBackground()
}