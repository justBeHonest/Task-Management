package com.ahmetaliasik.taskmanagement.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun IconWithBackground(modifier: Modifier = Modifier, color: Color, painterId: Int) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(painterId),
            contentDescription = "Icon Button",
            modifier = Modifier
                .background(
                    color = color.copy(alpha = 0.3f),
                    shape = RoundedCornerShape(8.dp)
                )
        )
    }
}