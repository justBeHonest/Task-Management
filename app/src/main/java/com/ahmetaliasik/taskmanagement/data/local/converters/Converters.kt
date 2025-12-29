package com.ahmetaliasik.taskmanagement.data.local.converters

import androidx.room.TypeConverter
import com.ahmetaliasik.taskmanagement.core.enum.TaskGroup
import com.ahmetaliasik.taskmanagement.core.enum.TaskType
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

class Converters {

    // --- Tarih Çeviricileri ---
    @TypeConverter
    fun fromTimestamp(value: Long?): LocalDateTime? {
        return value?.let {
            LocalDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneId.systemDefault())
        }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDateTime?): Long? {
        return date?.atZone(ZoneId.systemDefault())?.toInstant()?.toEpochMilli()
    }

    // --- TaskGroup Enum Çeviricileri ---
    @TypeConverter
    fun fromTaskGroup(value: String): TaskGroup {
        return try {
            TaskGroup.valueOf(value)
        } catch (e: Exception) {
            TaskGroup.OfficeProject // Hata olursa varsayılan
        }
    }

    @TypeConverter
    fun taskGroupToString(group: TaskGroup): String {
        return group.name
    }

    // --- TaskType Enum Çeviricileri ---
    @TypeConverter
    fun fromTaskType(value: String): TaskType {
        return try {
            TaskType.valueOf(value)
        } catch (e: Exception) {
            TaskType.Todo // Varsayılan
        }
    }

    @TypeConverter
    fun taskTypeToString(type: TaskType): String {
        return type.name
    }
}