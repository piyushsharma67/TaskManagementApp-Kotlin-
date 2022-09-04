package com.example.mytaskactivity.dbInstance.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mytaskactivity.dataClass.TaskDB
import com.example.mytaskactivity.dbInstance.entities.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert
    fun insertTask(task: Task)

    @Query("SELECT * FROM tasks")
    fun getAllTasks() : Flow<List<Task>>

    @Insert
    fun saveTask(task:Task)


}