package com.ahmetaliasik.taskmanagement.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ahmetaliasik.taskmanagement.core.enum.TaskGroup
import com.ahmetaliasik.taskmanagement.core.enum.TaskType
import java.time.LocalDateTime

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,
    val description: String,
    val taskType: TaskType,
    val taskGroup: TaskGroup,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime,
    val logoUri: String?
)
