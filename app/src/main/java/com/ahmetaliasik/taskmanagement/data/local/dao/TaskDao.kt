package com.ahmetaliasik.taskmanagement.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ahmetaliasik.taskmanagement.data.local.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity)

    @Query("SELECT * FROM tasks WHERE startDate >= :startOfDay AND startDate < :endOfDay")
    fun getTasksForDate(startOfDay: Long, endOfDay: Long): Flow<List<TaskEntity>>


    @Query("SELECT COUNT(*) FROM tasks WHERE startDate >= :startOfDay AND startDate < :endOfDay")
    fun getTaskCountForDate(startOfDay: Long, endOfDay: Long): Flow<Int>

    @Query("DELETE FROM tasks")
    suspend fun clearAllTasks()

}