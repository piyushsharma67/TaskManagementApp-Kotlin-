package com.example.mytaskactivity

import android.app.Application
import com.example.mytaskactivity.dbInstance.DbInstance
import com.example.mytaskactivity.repository.TaskRepository

class MainApplicationClass:Application() {

    lateinit var taskRepository: TaskRepository

    override fun onCreate() {
        super.onCreate()
        val dbInstance=DbInstance.getDbInstance(applicationContext)
        taskRepository=TaskRepository(dbInstance)
    }
}