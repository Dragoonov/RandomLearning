package com.example.randomlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        findViewById<Button>(R.id.button).setOnClickListener {
            System.gc()
            Thread.sleep(1000)
            ReferenceHolder.printReferences(this)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}