package com.example.randomlearning

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colors = arrayOf(Color.BLACK, Color.RED, Color.GRAY, Color.BLUE)
        val thicks = arrayOf(1,2,3,4)

        val hairs: MutableList<VaryingHair> = mutableListOf()
        val rand =  Random(1)
        repeat(1000000) {
            hairs.add(VaryingHair(
                colors[rand.nextInt(4)],
                thicks[rand.nextInt(4)],
                3, 4 to 5
            ))
        }
        Log.d("Flyweight","Number of light VaryingHair objects: " + hairs.size + ", number of heavy Hair objects: " + HairFactory.getHairsSize())
    }
}


class HairFactory {

    companion object {
        private val hairs: MutableList<Hair> = mutableListOf()

        fun lookForHair(color: Int, thickness: Int): Hair {
            val hair = hairs.find { it.getValues() == color to thickness }
            return hair ?: Hair(color, thickness).apply {
                hairs.add(this)
            }
        }
        fun getHairsSize() = hairs.size
    }

}
// Heeeavy object
data class Hair (private val color: Int, private val thickness: Int) {
    fun getValues(): Pair<Int,Int> = color to thickness
}

class VaryingHair(color: Int, thickness: Int,private val length: Int,private val coord: Pair<Int, Int>) {
    private val hair: Hair = HairFactory.lookForHair(color,thickness)
}

