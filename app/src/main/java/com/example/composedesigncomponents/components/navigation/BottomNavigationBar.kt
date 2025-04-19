package com.example.composedesigncomponents.components.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedesigncomponents.R
import com.example.composedesigncomponents.ui.theme.LocalInterFontFamily
import com.example.composedesigncomponents.ui.theme.Neutral0
import com.example.composedesigncomponents.ui.theme.Neutral900
import com.example.composedesigncomponents.ui.theme.Primary500
import com.example.composedesigncomponents.ui.theme.Secondary500

class WaveCutOutRoundedShape(
    private val cornerRadius: Dp,
    private val waveWidthPercent: Float,
    private val waveDepth: Dp
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val width = size.width
        val height = size.height

        val cornerPx = with(density) { cornerRadius.toPx() }
        val waveDepthPx = with(density) { waveDepth.toPx() }

        val waveStartX = (width * (1 - waveWidthPercent)) / 2f
        val waveEndX = waveStartX + (width * waveWidthPercent)
        val waveMidX = (waveStartX + waveEndX) / 2f

        val path = Path().apply {
            moveTo(0f, cornerPx)
            arcTo(
                rect = Rect(0f, 0f, cornerPx * 2, cornerPx * 2),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = true
            )

            lineTo(waveStartX, 0f)

            cubicTo(
                waveStartX + (waveMidX - waveStartX) * 0.4f, 0f,
                waveMidX - (waveMidX - waveStartX) * 0.5f, waveDepthPx,
                waveMidX, waveDepthPx
            )
            cubicTo(
                waveMidX + (waveEndX - waveMidX) * 0.5f, waveDepthPx,
                waveEndX - (waveEndX - waveMidX) * 0.4f, 0f,
                waveEndX, 0f
            )

            lineTo(width - cornerPx, 0f)
            arcTo(
                rect = Rect(width - 2 * cornerPx, 0f, width, cornerPx * 2),
                startAngleDegrees = 270f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            lineTo(width, height - cornerPx)
            arcTo(
                rect = Rect(width - 2 * cornerPx, height - 2 * cornerPx, width, height),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            lineTo(cornerPx, height)
            arcTo(
                rect = Rect(0f, height - 2 * cornerPx, cornerPx * 2, height),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            lineTo(0f, cornerPx)
            close()
        }

        return Outline.Generic(path)
    }
}


@Composable
fun BottomNavigationBar() {

    val navItems = listOf(
        NavigationItem(R.drawable.home, "Home"),
        NavigationItem(R.drawable.reports, "Reports"),
        NavigationItem(R.drawable.analytics, "Analytics"),
        NavigationItem(R.drawable.account, "Account")
    )
    var selectedItem by remember { mutableIntStateOf(0) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                WaveCutOutRoundedShape(
                    waveWidthPercent = 0.3f,
                    waveDepth = 28.dp,
                    cornerRadius = 24.dp
                )
            )
            .background(Neutral0)
            .padding(top = 18.dp, bottom = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        navItems.forEachIndexed { index, item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        selectedItem = index
                    }
                    .padding(
                        end = if (index == 1) 20.dp else 0.dp,
                        start = if (index == 2) 20.dp else 0.dp
                    )
            ) {
                Icon(
                    painterResource(id = item.icon),
                    contentDescription = item.label,
                    tint = if (selectedItem == index) Primary500 else Secondary500
                )
                Text(
                    text = item.label,
                    fontSize = 10.sp,
                    fontFamily = LocalInterFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = if (selectedItem == index) Neutral900 else Secondary500,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}


@Preview
@Composable
private fun Preview() {
    BottomNavigationBar()
}