package com.example.mytaskactivity.mainActivityViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mytaskactivity.repository.TaskRepository

class MainActivityViewModelFactory(val repository:TaskRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(repository) as T
    }
}