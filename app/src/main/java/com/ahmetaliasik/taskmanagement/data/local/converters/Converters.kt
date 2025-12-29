package com.ahmetaliasik.taskmanagement.data.local.converters

import androidx.room.TypeConverter
import com.ahmetaliasik.taskmanagement.core.enum.TaskGroup
import com.ahmetaliasik.taskmanagement.core.enum.TaskType
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId


class Converters {
    @TypeConverter
    fun fromTimeStamp(value: Long?): LocalDateTime? {
        return value?.let {
            LocalDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneId.systemDefault())
        }
    }

    @TypeConverter
    fun dateToTimeStamp(date: LocalDateTime?): Long? {
        return date?.atZone(ZoneId.systemDefault())?.toInstant()?.toEpochMilli()
    }

    @TypeConverter
    fun fromTaskGroup(value: String): TaskGroup {
        return try {
            TaskGroup.valueOf(value)
        } catch (e: Exception) {
            TaskGroup.OfficeProject
        }
    }

    @TypeConverter
    fun taskGroupToString(group: TaskType): String {
        return group.name
    }

    @TypeConverter
    fun fromTaskType(value: String): TaskType {
        return try {
            TaskType.valueOf(value)
        } catch (e: Exception) {
            TaskType.Todo
        }
    }

    @TypeConverter
    fun taskTypeToString(type: TaskType): String {
        return type.name
    }
}