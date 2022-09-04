package com.example.mytaskactivity.fragments.addtaskFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mytaskactivity.repository.TaskRepository

class AddTaskViewModelFactory(val repository: TaskRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddTaskViewModel(repository) as T
    }
}