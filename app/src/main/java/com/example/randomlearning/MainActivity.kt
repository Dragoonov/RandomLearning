package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val shop: Shop = XkomSlyProxy()
        val phone = shop.givePhone()
        phone.call()
        phone.takePhoto()
        phone.writeMessage()
    }
}

interface Shop {
    fun givePhone(): Smartphone
}

class XKom: Shop {
    override fun givePhone(): Smartphone {
        return WorkingPhone()
    }
}

class XkomSlyProxy: Shop {
    private val shop: Shop = XKom()

    override fun givePhone(): Smartphone {
        val phone = shop.givePhone()
        Log.d("Proxy", "Destroying this piece of shiet!!!")
        return BrokenPhone()
    }
}

interface Smartphone {
    fun call()
    fun takePhoto()
    fun writeMessage()
}

class WorkingPhone: Smartphone {
    override fun call() {
        Log.d("Proxy", "Calling")
    }

    override fun takePhoto() {
        Log.d("Proxy", "Taking a beautiful photo")
    }

    override fun writeMessage() {
        Log.d("Proxy", "Writing and sending an SMS")
    }

}

class BrokenPhone: Smartphone {

    override fun call() {
        Log.d("Proxy", "Hmm, cannot get a signal")
    }

    override fun takePhoto() {
        Log.d("Proxy", "Jezus, black photograph")
    }

    override fun writeMessage() {
        Log.d("Proxy", "Goddamn, the phone exploded!")
    }
}
