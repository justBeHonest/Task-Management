package com.ahmetaliasik.taskmanagement.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ahmetaliasik.taskmanagement.R

@Composable
fun InProgressCard(
    modifier: Modifier = Modifier,
    indicatorColor: Color,
    iconColor: Color,
    projectType: String,
    content: String,
    percent: Float,
) {
    Box {
        Column(
            modifier = Modifier
                .background(
                    color = indicatorColor.copy(alpha = 0.1f),
                    shape = RoundedCornerShape(19.dp)
                )
                .size(
                    202.dp, 116.dp
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = projectType,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = content,
                style = MaterialTheme.typography.bodyLarge,
            )
            Spacer(modifier = Modifier.height(16.dp))
            LinearProgressIndicator(
                progress = { percent },
                color = indicatorColor,
                trackColor = Color.Transparent,
                drawStopIndicator = {},
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.onPrimary,
                        shape = RoundedCornerShape(30.dp)
                    )
                    .height(6.dp)
            )
        }
        IconContainer(
            modifier = Modifier
                .offset((-12).dp, 12.dp)
                .align(Alignment.TopEnd),
            iconColor = iconColor,
            size = 14.dp,
            painterId = R.drawable.briefcase,
        )
    }
}

@Composable
fun IconContainer(modifier: Modifier = Modifier, iconColor: Color, painterId: Int, size: Dp) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .background(
                    color = iconColor.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(7.dp)
                )
                .padding(5.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.briefcase),
                contentDescription = "Icon",
                modifier = Modifier.size(size),
                colorFilter = ColorFilter.tint(color = iconColor)
            )
        }
    }
}