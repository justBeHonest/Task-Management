package com.ahmetaliasik.taskmanagement.core.enum

import androidx.compose.ui.graphics.Color
import com.ahmetaliasik.taskmanagement.ui.theme.ColorPrimary

enum class TaskType(val color: Color, val text: String) {
    Todo((Color(0xFF0087FF)), "To do"),
    InProgress(Color(0xFFFF7D53), text = "In Progress"),
    Completed(ColorPrimary, "Completed")
}