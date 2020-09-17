package com.example.randomlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.randomlearning.developer.Developer
import com.example.randomlearning.developer.Product
import com.example.randomlearning.developer_impl.BoatDeveloper
import com.example.randomlearning.developer_impl.HouseDeveloper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val developer: Developer = BoatDeveloper()
        val product: Product = developer.develop()
        val developer2: Developer = HouseDeveloper()
        val product2: Product = developer2.develop()
        Log.v("Main", product.getPrice().toString())
        Log.v("Main", product2.getPrice().toString())
    }
}
