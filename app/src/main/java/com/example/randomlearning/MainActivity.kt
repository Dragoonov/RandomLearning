package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = listOf(1,2,3,4,5,6,7,8)

        val iterator = list.getEverySecondIterator()
        val secondIterator = list.getFromEndIterator()

        while(iterator.hasNext()) {
            Log.d("Iterator", iterator.next().toString())
        }

        while(secondIterator.hasNext()) {
            Log.d("Iterator", secondIterator.next().toString())
        }

    }
}

fun <T> Collection<T>.getEverySecondIterator(): MyIterator<T> = EverySecondIterator(this)

fun <T> Collection<T>.getFromEndIterator(): MyIterator<T> = FromEndIterator(this)

interface MyIterator<T> {
    fun hasNext(): Boolean
    fun next(): T
}

class EverySecondIterator<T>(private val collection: Collection<T>): MyIterator<T> {
    private var currentPosition = 0

    override fun hasNext() = currentPosition < collection.size

    override fun next(): T = collection.elementAt(currentPosition).also { currentPosition += 2 }

}

class FromEndIterator<T>(private val collection: Collection<T>): MyIterator<T> {
    private var currentPosition = collection.size-1

    override fun hasNext(): Boolean = currentPosition >= 0

    override fun next(): T = collection.elementAt(currentPosition).also { currentPosition -= 1 }

}


