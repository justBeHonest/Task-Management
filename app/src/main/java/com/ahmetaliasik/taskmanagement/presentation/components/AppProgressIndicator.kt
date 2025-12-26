package com.ahmetaliasik.taskmanagement.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Composable
fun AppProgressIndicator(
    modifier: Modifier = Modifier, color: Color, progress: Float,
    strokeWidth: Dp,

    ) {
    Box(
        modifier = modifier
    ) {
        CircularProgressIndicator(
            progress = { 0f },
            trackColor = color.copy(alpha = 0.3f),
            modifier = Modifier.fillMaxSize(),
            strokeWidth = strokeWidth,
        )
        CircularProgressIndicator(
            progress = { progress },
            color = color,
            trackColor = Color.Transparent,
            modifier = Modifier
                .fillMaxSize()
                .scale(-1f, 1f),
            strokeWidth = strokeWidth,
        )
        Text("${(progress * 100).toInt()}%", modifier = Modifier.align(Alignment.Center))
    }

}
