package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val human = Human()
        val spider = Tarantula()
        val adapter = HumanSpiderAdapter(human)
        val holeForSpider = SpiderHole()
        val holeForHuman = SpiderHole()

        holeForSpider.receive(spider)
        holeForHuman.receive(adapter)

        Log.v("Main", holeForHuman.taken.toString() + " " + holeForSpider.taken.toString())
    }
}

interface Spider {
    fun legSpan(): Int
}

class SpiderHole {

    var taken = false
    private val maxLegSpan = 20

    private fun isBigEnough(spider: Spider): Boolean {
        return spider.legSpan() < maxLegSpan
    }

    fun receive (spider: Spider) {
        if (isBigEnough(spider) || taken) {
            taken = true
        }
    }
}

class Tarantula: Spider {
    private val legLength = 3
    override fun legSpan() = legLength*8
}

class Human {
    val leftHand = 2
    val rightHand = 4
    val leftLeg = 6
    val rightLeg = 6
}

class HumanSpiderAdapter(private val human: Human): Spider {

    override fun legSpan(): Int {
        return human.leftLeg + human.rightLeg + human.leftHand + human.rightHand
    }
}
