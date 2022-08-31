package com.example.mytaskactivity.splashActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.mytaskactivity.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler().apply {
            postDelayed({
                val intent= Intent(baseContext,MainActivity::class.java)
                startActivity(intent)
            }, 1000)
        }
    }
}