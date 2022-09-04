package com.example.mytaskactivity.mainActivityViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.mytaskactivity.dbInstance.entities.Task
import com.example.mytaskactivity.repository.TaskRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainActivityViewModel(val repository: TaskRepository) :ViewModel(){

    private var _tasks= MutableLiveData<Task>()

    val taskLiveData:LiveData<Task>
    get() = _tasks

   init{
       fetchTasks()
   }

    fun fetchTasks(): Flow<List<Task>> {
        val data=repository.fetchTasks()
        Log.d("data",data.toString())
        return data
    }

}