package com.ahmetaliasik.taskmanagement.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ahmetaliasik.taskmanagement.core.enum.TaskGroup
import com.ahmetaliasik.taskmanagement.core.enum.TaskType
import com.ahmetaliasik.taskmanagement.data.local.AppDatabase
import com.ahmetaliasik.taskmanagement.data.local.entity.TaskEntity
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val taskDao = AppDatabase.getDatabase(application).taskDao()

    private val startOfDay =
        LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
    private val endOfDay =
        LocalDate.now().atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant()
            .toEpochMilli()

    val todaysTasks: StateFlow<List<TaskEntity>> =
        taskDao.getTasksForDate(startOfDay, endOfDay)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val todaysTaskCount: StateFlow<Int> = taskDao.getTaskCountForDate(startOfDay, endOfDay)
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0)

    fun saveTask(
        title: String,
        description: String,
        group: TaskGroup,
        startDate: Long,
        endDate: Long,
        imageUri: String?,
    ) {
        viewModelScope.launch {
            val startDateTime = LocalDateTime.ofInstant(
                java.time.Instant.ofEpochMilli(startDate),
                ZoneId.systemDefault()
            )

            val endDateTime = LocalDateTime.ofInstant(
                java.time.Instant.ofEpochMilli(endDate),
                ZoneId.systemDefault()
            )

            val newTask = TaskEntity(
                title = title,
                description = description,
                taskType = TaskType.Todo,
                taskGroup = group,
                startDate = startDateTime,
                endDate = endDateTime,
                logoUri = imageUri,
            )

            taskDao.insertTask(newTask)
        }
    }

}