package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val robot = Robot()
        val mean = MeanRobotStrategy()
        val nice = NiceRobotStrategy()
        val neutral = IndifferentRobotStrategy()

        robot.changeStrategy(mean)
        robot.sayHello()
        robot.sayGoodbye()
        robot.play()

        robot.changeStrategy(nice)
        robot.sayHello()
        robot.sayGoodbye()
        robot.play()

        robot.changeStrategy(neutral)
        robot.sayHello()
        robot.sayGoodbye()
        robot.play()
    }
}

class Robot {

    private var strategy: RobotStrategy? = null

    fun changeStrategy(state: RobotStrategy) {
        this.strategy = state
    }

    fun sayHello() {
        strategy?.sayHello()
    }

    fun sayGoodbye() {
        strategy?.sayGoodbye()
    }

    fun play() {
        strategy?.play()
    }
}

abstract class RobotStrategy {
    abstract fun sayHello()
    abstract fun sayGoodbye()
    abstract fun play()
}

class NiceRobotStrategy: RobotStrategy() {
    override fun sayHello() {
        Log.d("State", "Hello, nice to meet you, I'm a robot")
    }

    override fun sayGoodbye() {
        Log.d("State", "Goodbye friends,  hope to meet again! :)))")
    }

    override fun play() {
        Log.d("State", "Let's play, it's so fun :D")
    }
}

class IndifferentRobotStrategy: RobotStrategy() {
    override fun sayHello() {
        Log.d("State", "Hey.")
    }

    override fun sayGoodbye() {
        Log.d("State", "Bye.")
    }

    override fun play() {
        Log.d("State", "Whatever.")
    }
}

class MeanRobotStrategy: RobotStrategy() {
    override fun sayHello() {
        Log.d("State", "What are you looking at, you shit piecies?!11")
    }

    override fun sayGoodbye() {
        Log.d("State", "Get the fuck out you whores!!!")
    }

    override fun play() {
        Log.d("State", "I'm gonna smash your heads and rip open your bellies!")
    }
}