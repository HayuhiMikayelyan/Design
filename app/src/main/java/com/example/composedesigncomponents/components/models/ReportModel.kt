package com.example.composedesigncomponents.components.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class ReportModel(
    @DrawableRes val background: Int,
    @DrawableRes val image: Int,
    val color: Color? = null,
    val title: String,
    val imageHint: String,
    val amountHint: String? = null,
    val dateHint: String? = null,
    val date: String,
    val categoryHint: String
)
