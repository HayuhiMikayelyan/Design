package com.example.composedesigncomponents.components.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composedesigncomponents.ui.theme.Green100
import com.example.composedesigncomponents.ui.theme.Green800


@Composable
fun AccountPage(
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Green100)
    ) {

        Text(
            text = "Account",
            modifier = Modifier.align(Alignment.Center),
            color = Green800,
            fontSize = 32.sp
        )
    }
}


@Preview
@Composable
private fun Preview() {
    AccountPage(navController = rememberNavController())
}