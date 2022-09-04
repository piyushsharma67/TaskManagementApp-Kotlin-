package com.example.mytaskactivity.fragments.addtaskFragment

import androidx.lifecycle.ViewModel
import com.example.mytaskactivity.repository.TaskRepository

class AddTaskViewModel(val repository: TaskRepository) : ViewModel() {

    fun savetask(task:String,time:String){
        repository.saveTaskWithTime(task,time)

    }
}