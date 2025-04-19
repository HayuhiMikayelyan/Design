package com.example.composedesigncomponents.components.navigation

import androidx.annotation.DrawableRes

data class NavigationItem(
    @DrawableRes val icon: Int,
    val label: String
)