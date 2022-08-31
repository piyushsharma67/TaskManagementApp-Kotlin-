package com.example.mytaskactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mytaskactivity.repository.TaskRepository

class MainActivity : AppCompatActivity() {

    lateinit var repository: TaskRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }
}