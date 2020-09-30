package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val riggedToyBuilder = RiggedToyBuilder()
        val normalBuilder = NormalToyBuilder()

        riggedToyBuilder.buildToy()

        normalBuilder.buildToy()
    }
}

abstract class ToyBuilder {
    fun buildToy() {
        placeLegs()
        placeHands()
        fillBelly()
        attachEyes()
        glueHair()
    }

    private fun placeLegs() {
        Log.d("Template", "Placing the legs on toy")
    }
    private fun placeHands() {
        Log.d("Template", "Placing the hands on toy")

    }
    protected abstract fun fillBelly()
    protected abstract fun attachEyes()
    private fun glueHair() {
        Log.d("Template", "Glueing hair")

    }

}

class NormalToyBuilder: ToyBuilder() {

    override fun attachEyes() {
        Log.d("Template", "Attaching normal sweet eyes")
    }

    override fun fillBelly() {
        Log.d("Template", "Filling the belly with feathers")

    }
}

class RiggedToyBuilder: ToyBuilder() {
    override fun fillBelly() {
        Log.d("Template", "Filling belly with poison")

    }

    override fun attachEyes() {
        Log.d("Template", "Attaching the diabolical eyes")

    }
}
