package com.ahmetaliasik.taskmanagement.presentation.test

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmetaliasik.taskmanagement.ui.theme.TaskManagementTheme

@Composable
fun TestView(modifier: Modifier = Modifier) {

}

@Preview
@Composable
private fun TestPreview() {
    TaskManagementTheme {
        Box(
            modifier = Modifier
                .size(200.dp)
                .drawBehind {
                    val path = Path().apply {
                        moveTo(100f, 100f)
                        lineTo(200f, 200f)
                        lineTo(100f, 200f)
                        close()
                    }
                    drawPath(
                        path = path,
                        color = Color.Red
                    )
                }
        )
    }
}