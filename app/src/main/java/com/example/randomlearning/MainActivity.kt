package com.example.randomlearning

import android.content.Intent
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import androidx.annotation.RequiresApi

fun printMessage(message: Any?) = Log.v(MainActivity::class.simpleName, message.toString())

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Intent(this, ExampleService::class.java).also {
            startForegroundService(it)
            startForegroundService(it)
            startForegroundService(it)
        }
    }
}
