package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val robot = Robot()
        val mean = MeanRobotState()
        val nice = NiceRobotState()
        val neutral = IndifferentRobotState()

        robot.changeState(mean)
        robot.sayHello()
        robot.sayGoodbye()
        robot.play()

        robot.changeState(nice)
        robot.sayHello()
        robot.sayGoodbye()
        robot.play()

        robot.changeState(neutral)
        robot.sayHello()
        robot.sayGoodbye()
        robot.play()
    }
}

class Robot {

    private var state: RobotState? = null

    fun changeState(state: RobotState) {
        this.state = state
    }

    fun sayHello() {
        state?.sayHello()
    }

    fun sayGoodbye() {
        state?.sayGoodbye()
    }

    fun play() {
        state?.play()
    }
}

abstract class RobotState {
    abstract fun sayHello()
    abstract fun sayGoodbye()
    abstract fun play()
}

class NiceRobotState: RobotState() {
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

class IndifferentRobotState: RobotState() {
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

class MeanRobotState: RobotState() {
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