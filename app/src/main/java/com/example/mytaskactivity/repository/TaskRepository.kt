package com.example.mytaskactivity.repository

import android.util.Log
import com.example.mytaskactivity.dataClass.TaskDB
import com.example.mytaskactivity.dbInstance.DbInstance
import com.example.mytaskactivity.dbInstance.entities.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch

class TaskRepository(val dbInstance: DbInstance) {

    fun fetchTasks():Flow<List<Task>>{
        val tasks=dbInstance.taskDao().getAllTasks()
        return tasks
    }

    fun saveTask(task:String){
       CoroutineScope(Dispatchers.IO).launch {
           dbInstance.taskDao().insertTask(Task(task=task,id=null))
       }
    }
}