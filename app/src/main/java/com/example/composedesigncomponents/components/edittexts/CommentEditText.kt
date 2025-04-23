package com.example.composedesigncomponents.components.edittexts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedesigncomponents.ui.theme.BackgroundMain2
import com.example.composedesigncomponents.ui.theme.LocalInterFontFamily
import com.example.composedesigncomponents.ui.theme.StrokeStrong
import com.example.composedesigncomponents.ui.theme.TextPlaceholder

@Composable
fun CommentEditText(
    modifier: Modifier = Modifier,
    hint: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = StrokeStrong,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
            .background(BackgroundMain2)
            .padding(12.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Text(
            text = hint,
            fontSize = 16.sp,
            fontFamily = LocalInterFontFamily,
            fontWeight = FontWeight.Normal,
            color = TextPlaceholder,
        )
    }
}

@Preview
@Composable
private fun Preview() {
    CommentEditText(hint = "Write your comments here", modifier = Modifier.height(82.dp))
}