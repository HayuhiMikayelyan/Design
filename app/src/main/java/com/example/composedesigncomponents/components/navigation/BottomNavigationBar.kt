package com.example.composedesigncomponents.components.navigation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composedesigncomponents.R
import com.example.composedesigncomponents.components.models.AnimatedCard
import com.example.composedesigncomponents.components.models.NavigationItem
import com.example.composedesigncomponents.components.shapes.WaveCutOutRoundedShape
import com.example.composedesigncomponents.times
import com.example.composedesigncomponents.transform
import com.example.composedesigncomponents.ui.theme.BrandSecondaryBlue100
import com.example.composedesigncomponents.ui.theme.BrandSecondaryBlue800
import com.example.composedesigncomponents.ui.theme.ButtonTertiaryDisabled
import com.example.composedesigncomponents.ui.theme.Gray
import com.example.composedesigncomponents.ui.theme.Green200
import com.example.composedesigncomponents.ui.theme.Green900
import com.example.composedesigncomponents.ui.theme.LocalInterFontFamily
import com.example.composedesigncomponents.ui.theme.Neutral0
import com.example.composedesigncomponents.ui.theme.Neutral900
import com.example.composedesigncomponents.ui.theme.Primary500
import com.example.composedesigncomponents.ui.theme.Purple100
import com.example.composedesigncomponents.ui.theme.Purple800
import com.example.composedesigncomponents.ui.theme.Secondary500
import com.example.composedesigncomponents.ui.theme.TextOnLight

@Composable
fun getFabAnimationProgress(isMenuExtended: MutableState<Boolean>): Float {
    val fabAnimationProgress by animateFloatAsState(
        targetValue = if (isMenuExtended.value) 1f else 0f, animationSpec = tween(
            durationMillis = 1000, easing = LinearEasing
        ), label = ""
    )
    return fabAnimationProgress
}

@Composable
fun BottomNavigationBar(
    navController: NavController, modifier: Modifier = Modifier
) {
    val isMenuExtended = remember { mutableStateOf(false) }

    val navItems = listOf(
        NavigationItem(R.drawable.home, "Home", Screen.Home.route),
        NavigationItem(R.drawable.reports, "Reports", Screen.Reports.route),
        NavigationItem(R.drawable.analytics, "Analytics", Screen.Analytics.route),
        NavigationItem(R.drawable.account, "Account", Screen.Account.route)
    )
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val fabAnimationProgress = getFabAnimationProgress(isMenuExtended = isMenuExtended)

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(170.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Gray.copy(alpha = 0.9f)),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clip(
                    WaveCutOutRoundedShape(
                        waveWidthPercent = 0.3f, waveDepth = 28.dp, cornerRadius = 24.dp
                    )
                )
                .background(Neutral0)
                .padding(top = 18.dp, bottom = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            navItems.forEachIndexed { index, item ->
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clickable(indication = null,
                            interactionSource = remember { MutableInteractionSource() }) {
                            if (!isMenuExtended.value && fabAnimationProgress == 0f) {
                                if (currentRoute != item.route) {
                                    navController.navigate(item.route) {
                                        popUpTo(Screen.Home.route) { saveState = true }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            }

                        }
                        .padding(
                            end = if (index == 1) 20.dp else 0.dp,
                            start = if (index == 2) 20.dp else 0.dp
                        )) {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = item.label,
                        tint = if (currentRoute == item.route) Primary500 else Secondary500
                    )
                    Text(
                        text = item.label,
                        fontSize = 10.sp,
                        fontFamily = LocalInterFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        color = if (currentRoute == item.route) Neutral900 else Secondary500,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }

        val boxHeight by animateDpAsState(
            targetValue = if (isMenuExtended.value) 420.dp else 0.dp,
            label = "BoxHeight",
            animationSpec = tween(durationMillis = 1000)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(boxHeight)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.White, Color.White),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )

        AnimatedFab(
            modifier = modifier
                .size(56.dp)
                .offset(y = (-56).dp)
                .scale(
                    1f - LinearEasing.transform(0.5f, 0.85f, fabAnimationProgress)
                )
                .clip(CircleShape),
        )

        FabGroup(
            modifier = modifier,
            renderEffect = null,
            animationProgress = fabAnimationProgress,
            toggleAnimation = { isMenuExtended.value = isMenuExtended.value.not() },
            navController = navController
        )
    }
}

@Composable
fun AnimatedFab(
    modifier: Modifier,
    icon: ImageVector? = null,
    opacity: Float = 1f,
    backgroundColor: Color = Primary500,
    onClick: () -> Unit = {}
) {
    FloatingActionButton(
        onClick = onClick,
        elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp),
        containerColor = backgroundColor,
        modifier = modifier
    ) {
        icon?.let {
            Icon(
                imageVector = it,
                contentDescription = null,
                tint = TextOnLight.copy(alpha = opacity)
            )
        }
    }
}

@Composable
fun FabGroup(
    navController: NavController,
    modifier: Modifier = Modifier,
    animationProgress: Float = 0f,
    renderEffect: RenderEffect? = null,
    toggleAnimation: () -> Unit = { }
) {
    Box(
        modifier
            .fillMaxSize()
            .graphicsLayer { this.renderEffect = renderEffect },
        contentAlignment = Alignment.BottomCenter
    ) {
        val backgroundColor = lerp(
            start = Primary500,
            stop = ButtonTertiaryDisabled,
            fraction = FastOutSlowInEasing.transform(
                0.35f,
                0.65f,
                animationProgress.coerceIn(0f, 1f)
            )
        )

        AnimatedFab(
            icon = Icons.Default.Add, modifier = Modifier
                .size(56.dp)
                .offset(y = (-56).dp)
                .rotate(
                    225 * FastOutSlowInEasing.transform(0.35f, 0.65f, animationProgress)
                )
                .clip(CircleShape), onClick = toggleAnimation, backgroundColor = backgroundColor
        )


        AnimatedCard(
            animatedCard = AnimatedCard(
                R.drawable.income, "Income", Green200, Green900, Green900, Screen.AddIncome.route
            ),
            modifier = Modifier.padding(
                PaddingValues(
                    bottom = 128.dp, end = 248.dp
                ) * FastOutSlowInEasing.transform(0f, 0.8f, animationProgress)
            ),
            opacity = LinearEasing.transform(0.5f, 0.8f, animationProgress),
            animationProgress = animationProgress,
            navController = navController
        )

        AnimatedCard(
            animatedCard = AnimatedCard(
                R.drawable.expense,
                "Expense",
                Purple100,
                Purple800,
                Green900,
                Screen.AddExpense.route
            ),
            modifier = Modifier.padding(
                PaddingValues(
                    bottom = 148.dp,
                ) * FastOutSlowInEasing.transform(0.1f, 0.9f, animationProgress)
            ),
            opacity = LinearEasing.transform(0.3f, 0.8f, animationProgress),
            animationProgress = animationProgress,
            navController = navController

        )

        AnimatedCard(
            animatedCard = AnimatedCard(
                R.drawable.other_document,
                "Other Document",
                BrandSecondaryBlue100,
                BrandSecondaryBlue800,
                Green900,
                Screen.AddDocument.route
            ),
            modifier = Modifier.padding(
                PaddingValues(
                    bottom = 128.dp, start = 248.dp
                ) * FastOutSlowInEasing.transform(0f, 0.8f, animationProgress)
            ),
            opacity = LinearEasing.transform(0.5f, 0.8f, animationProgress),
            animationProgress = animationProgress,
            navController = navController

        )
    }
}

@Composable
fun AnimatedCard(
    navController: NavController,
    modifier: Modifier = Modifier,
    animatedCard: AnimatedCard,
    opacity: Float = 1f,
    animationProgress: Float,
) {

    Column(modifier = modifier
        .alpha(opacity)
        .size(116.dp, 80.dp)
        .clip(RoundedCornerShape(24.dp))
        .background(animatedCard.backgroundColor)
        .clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }) {
            if (animationProgress == 1f) {
                navController.navigate(animatedCard.route) {
                    popUpTo(Screen.Home.route) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = animatedCard.icon),
            contentDescription = animatedCard.text,
            tint = animatedCard.iconColor
        )
        Text(
            text = animatedCard.text,
            fontSize = 14.sp,
            fontFamily = LocalInterFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = animatedCard.foregroundColor,
            textAlign = TextAlign.Center
        )
    }
}


@Preview
@Composable
private fun Preview() {
    BottomNavigationBar(navController = rememberNavController())
}