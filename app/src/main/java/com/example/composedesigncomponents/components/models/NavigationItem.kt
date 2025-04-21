package com.example.composedesigncomponents.components.models

import androidx.annotation.DrawableRes

data class NavigationItem(
    @DrawableRes val icon: Int,
    val label: String
)