package com.ahmetaliasik.taskmanagement.ui.theme.custom_shape

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import com.ahmetaliasik.taskmanagement.presentation.home.HomeView

class BottomNavbarCutOutShape(val fabRadius: Float) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val fabRadiusMultiple = fabRadius * 2
        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo((size.width / 2) - fabRadiusMultiple, 0f)
            cubicTo(
                x1 = (size.width / 2) - fabRadiusMultiple,
                y1 = 0f,
                x2 = (size.width / 2) - fabRadiusMultiple,
                y2 = fabRadiusMultiple,
                x3 = (size.width / 2),
                y3 = fabRadiusMultiple
            )

            // lineTo((size.width / 2), fabRadiusMultiple)

            cubicTo(
                x1 = size.width / 2,
                y1 = fabRadiusMultiple,
                x2 = size.width / 2 + fabRadiusMultiple,
                y2 = fabRadiusMultiple,
                x3 = (size.width / 2) + fabRadiusMultiple,
                y3 = 0f,
            )

            // lineTo((size.width / 2) + fabRadiusMultiple, 0f)


            lineTo(size.width, 0f)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            lineTo(0f, 0f)
            close()
        }
        return Outline.Generic(path)
    }
}


@Preview
@Composable
fun HomeViewPreview() {
    HomeView(
        navigateToAddProjectInTaskView = {}
    )
}