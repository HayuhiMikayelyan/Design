package com.example.composedesigncomponents.components.animations_shapes

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

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