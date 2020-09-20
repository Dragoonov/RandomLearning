package com.example.randomlearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val boat = Boat().also { it.init() }
        val boatClone = boat.clone()
        Log.v("Main", "$boat, $boatClone")
    }
}

//Wow, such a huge pattern
class Boat constructor(): Cloneable {

    private var isWooden by Delegates.notNull<Boolean>()
    private lateinit var name: String

    fun init() {
        isWooden = true
        name = "Boacik"
    }

    constructor(boat: Boat) : this() {
        this.isWooden = boat.isWooden
        this.name = boat.name
    }
    public override fun clone(): Boat = Boat(this)

    override fun toString(): String {
        return "$isWooden   $name"
    }
}
