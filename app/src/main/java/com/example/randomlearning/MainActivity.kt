package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gameStore = Publisher()
        listOf(
            HornyTeen("Tom"),
            HornyTeen("Jerry"),
            HornyTeen("Marco")
        ).also { list ->
            list.forEach { gameStore.subscribe(it) }
        }

        gameStore.newGame = "Some shit game"
        gameStore.newGame = "Even shittier game"
        gameStore.newGame = "Game not worth its price"

        //unsubscribe
    }
}

class Publisher {

    private val observers: MutableList<MyObserver> = mutableListOf()

    var newGame = "Mass Effect"
    set(value) {
        field = value
        notifyObservers()
    }

    fun subscribe(observer: MyObserver) {
        observers.add(observer)
    }

    fun unsubscribe(observer: MyObserver) {
        observers.remove(observer)
    }

    private fun notifyObservers() {
        observers.forEach { it.onChanged(newGame) }
    }
}

interface MyObserver {
    fun onChanged(game: String)
}

class HornyTeen(private val name: String): MyObserver {
    override fun onChanged(game: String) {
        Log.d("Observer","$name: AAAAAH NEW GAAAAAAAME I MUST HAVE ITTTTT: $game")
    }
}