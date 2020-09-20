package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val singleton = Singleton.getSingleton()
        singleton.value = "Mama"
        val singleton2 = Singleton.getSingleton()

        Log.v("Main", (singleton.value == singleton2.value).toString())
    }
}

//Wow, such a huge pattern
class Singleton private constructor() {
    var value: String = ""

    companion object {

        fun getSingleton(): Singleton {
            return if (instance == null) {
                instance = Singleton()
                instance as Singleton
            } else {
                instance as Singleton
            }
        }
        private var instance: Singleton? = null
    }

}
