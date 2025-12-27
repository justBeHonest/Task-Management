package com.ahmetaliasik.taskmanagement.core.enum

import androidx.compose.ui.graphics.Color
import com.ahmetaliasik.taskmanagement.R

enum class TaskGroup(val color: Color, val painterId: Int) {
    OfficeProject(Color(0xFFFF67BC), R.drawable.briefcase),
    PersonalProject(Color(0xFF5E60CE), R.drawable.user_octagon),
    DailyStudy(Color(0xFFFFB347), R.drawable.book),
    Casual(Color(0xFF48C9B0), R.drawable.book)
}

