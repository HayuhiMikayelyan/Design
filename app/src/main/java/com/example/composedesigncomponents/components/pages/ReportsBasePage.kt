package com.example.composedesigncomponents.components.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedesigncomponents.R
import com.example.composedesigncomponents.components.edittexts.CommentEditText
import com.example.composedesigncomponents.components.icons.RectangleIcon
import com.example.composedesigncomponents.components.icons.RoundIcon
import com.example.composedesigncomponents.components.models.ReportModel
import com.example.composedesigncomponents.components.spinners.CategoryPicker
import com.example.composedesigncomponents.ui.theme.BackgroundContainer2
import com.example.composedesigncomponents.ui.theme.ButtonPlain
import com.example.composedesigncomponents.ui.theme.IconRegular
import com.example.composedesigncomponents.ui.theme.LocalInterFontFamily
import com.example.composedesigncomponents.ui.theme.TextBody
import com.example.composedesigncomponents.ui.theme.TextExpense
import com.example.composedesigncomponents.ui.theme.TextIncome
import com.example.composedesigncomponents.ui.theme.TextOnLight
import com.example.composedesigncomponents.ui.theme.TextSubtitle


@Composable
fun ReportsBasePage(
    reportModel: ReportModel
) {
    reportModel.apply {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = background),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(430.dp)
                        .clip(RoundedCornerShape(bottomEnd = 32.dp, bottomStart = 32.dp)),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .padding(top = 48.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        RoundIcon(R.drawable.back, "Back", IconRegular, ButtonPlain)
                        Text(
                            text = title,
                            fontSize = 18.sp,
                            fontFamily = LocalInterFontFamily,
                            fontWeight = FontWeight.Bold,
                            color = TextOnLight
                        )
                        Spacer(modifier = Modifier.size(48.dp))
                    }

                    Image(
                        painter = painterResource(id = image), contentDescription = title,
                        modifier = Modifier
                            .padding(top = 36.dp)
                            .size(180.dp)
                    )

                    Text(
                        text = imageHint,
                        fontSize = 16.sp,
                        fontFamily = LocalInterFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = TextBody,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        RectangleIcon(
                            icon = R.drawable.camera,
                            text = "Photo",
                            tint = IconRegular,
                            backgroundColor = ButtonPlain,
                            textColor = TextSubtitle,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        RectangleIcon(
                            icon = R.drawable.image,
                            tint = IconRegular,
                            backgroundColor = ButtonPlain,
                            textColor = TextSubtitle,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        RectangleIcon(
                            icon = R.drawable.file,
                            tint = IconRegular,
                            textColor = TextSubtitle,
                            backgroundColor = ButtonPlain
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                amountHint?.let {
                    Text(
                        text = it,
                        fontSize = 16.sp,
                        fontFamily = LocalInterFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = TextBody
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        if (color != null) {
                            Text(
                                text = "₪",
                                fontSize = 38.sp,
                                fontFamily = LocalInterFontFamily,
                                fontWeight = FontWeight.Normal,
                                color = color
                            )

                            Text(
                                text = "--",
                                fontSize = 38.sp,
                                fontFamily = LocalInterFontFamily,
                                fontWeight = FontWeight.Normal,
                                color = color,
                                modifier = Modifier.alpha(alpha = 0.5f)
                            )
                        }
                    }
                }

                dateHint?.let {
                    Text(
                        text = it,
                        fontSize = 16.sp,
                        fontFamily = LocalInterFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = TextBody
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = if (dateHint != null) 4.dp else 12.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .background(BackgroundContainer2)
                        .padding(horizontal = 12.dp, vertical = 6.dp)

                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.calendar),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 4.dp)
                            .size(17.dp),
                        tint = IconRegular
                    )
                    Text(
                        text = date,
                        fontSize = 18.sp,
                        fontFamily = LocalInterFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = TextSubtitle,
                    )
                }

                CategoryPicker(
                    label = "Expense category",
                    hint = "Select one",
                    modifier = Modifier.padding(top = 40.dp)
                )
                Text(
                    text = "Comments (optional)",
                    fontSize = 14.sp,
                    fontFamily = LocalInterFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = TextSubtitle,
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .align(Alignment.Start)
                )
                CommentEditText(
                    hint = "Write your comments here",
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .height(82.dp)

                )

            }
        }
    }
}

@Composable
fun IncomePage() {
    ReportsBasePage(
        ReportModel(
            background = R.drawable.income_background,
            image = R.drawable.income_icon,
            color = TextIncome,
            title = "Income",
            imageHint = "Take a photo of your income document",
            amountHint = "Income amount",
            date = "11 Mar 2025",
            categoryHint = "Income category",
        )
    )
}

@Composable
fun ExpensePage() {
    ReportsBasePage(
        ReportModel(
            background = R.drawable.expense_background,
            image = R.drawable.expense_icon,
            color = TextExpense,
            title = "Expense",
            imageHint = "Take a photo of your expense document",
            amountHint = "Expense amount",
            date = "11 Mar 2025",
            categoryHint = "Expense category",
        )
    )
}

@Composable
fun DocumentPage() {
    ReportsBasePage(
        ReportModel(
            background = R.drawable.document_background,
            image = R.drawable.document_icon,
            title = "Other document",
            imageHint = "Take a photo of your document",
            date = "11 Mar 2025",
            dateHint = "Document date",
            categoryHint = "Document category",
        )
    )
}


@Preview
@Composable
private fun Preview() {
    IncomePage()
}