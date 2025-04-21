package com.example.composedesigncomponents.components.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class AnimatedCard(
    @DrawableRes val icon: Int,
    val text: String,
    val backgroundColor: Color,
    val foregroundColor: Color,
    val iconColor: Color
)