package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val witness = Witness()
        witness.walkFirst()
        witness.walkSecond()
        witness.walkThird()
        witness.walkFourth()

        Log.d("Memento", "Hey, I'm a policeman. There was a crime here. Tell me what you've been doing")

        witness.giveTestimony().forEach {
            Log.d("Memento",it.restore().toString())
        }
    }
}

data class Witness (
    private var streetName:String = "Dragon's Bay",
    private var holdingCigaro:Boolean = false,
    private var havingSunglasses:Boolean = false,
    private var weather:String = "Sunny",
    private var metersWalked:Int = 100
) {
    private val memory: MutableList<Memento> = mutableListOf()

    private fun produceSnapshot(): Memento = Memento(this)

    fun remember(): String = Gson().toJson(Snapshot())

    fun restore(state: String): Witness = Gson().fromJson(state, Snapshot::class.java).restoreWitness()

    fun walkFirst() {
        memory.add(produceSnapshot())
        Log.d("Memento", toString())
    }
    fun walkSecond() {
        streetName = "Snake's Tongue"
        metersWalked = 200
        memory.add(produceSnapshot())
        Log.d("Memento", toString())
    }

    fun walkThird() {
        metersWalked = 300
        holdingCigaro = true
        memory.add(produceSnapshot())
        Log.d("Memento", toString())
    }

    fun walkFourth() {
        metersWalked = 400
        havingSunglasses = true
        memory.add(produceSnapshot())
        Log.d("Memento", toString())
    }

    fun giveTestimony(): List<Memento> = memory

    override fun toString(): String {
        return "So I was walking down the $streetName, " +
                if (holdingCigaro) {
                    "holding cigaro and "
                } else {
                    ""
                } +
                if (havingSunglasses) {
                    "wearing sunglasses and "
                } else {
                    ""
                } + "the weather was $weather. I think I walked $metersWalked meters from the house."
    }

    private inner class Snapshot (
        val street: String = streetName,
        val cigaro: Boolean = holdingCigaro,
        val glasses: Boolean = havingSunglasses,
        val weath: String = weather,
        val meters: Int = metersWalked) {

        fun restoreWitness(): Witness = Witness(street, cigaro, glasses, weath, meters)
    }
}

class Memento (private val witness: Witness) {
    private val backup = witness.remember()

    fun restore() = witness.restore(backup)
}