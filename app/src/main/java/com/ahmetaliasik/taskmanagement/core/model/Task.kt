package com.ahmetaliasik.taskmanagement.core.model

import android.net.Uri
import com.ahmetaliasik.taskmanagement.core.enum.TaskGroup
import com.ahmetaliasik.taskmanagement.core.enum.TaskType
import java.time.LocalDateTime

data class Task(
    val taskType: TaskType,
    val taskGroup: TaskGroup,
    val title: String,
    val description: String,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val logoUri: Uri?,
)
