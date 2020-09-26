package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sender = Sender()
        CommandFactory.setReceiver(Receiver())
        sender.orderRunning(10)
        sender.orderLeaning()
    }
}

object CommandFactory {
    private lateinit var receiver: Receiver
    fun setReceiver(receiver: Receiver): CommandFactory {
        CommandFactory.receiver = receiver
        return CommandFactory
    }

    fun getRunningCommand(): RunningCommand {
        return RunningCommand(receiver)
    }

    fun getLeanCommand(): LeaningCommand {
        return LeaningCommand(receiver)
    }
}

class RunningCommand(private val receiver: Receiver) {
    fun execute(speed: Int) {
        receiver.runForward(speed)
    }
}

class LeaningCommand(private val receiver: Receiver) {
    fun execute() {
        receiver.leanBack()
    }
}

class Sender() {
    fun orderRunning(speed: Int) {
        CommandFactory.getRunningCommand().execute(speed)
    }

    fun orderLeaning() {
        CommandFactory.getLeanCommand().execute()
    }
}

class Receiver {
    fun runForward(speed: Int) {
        Log.d("Command", "I'm running forward as commanded with speed $speed")
    }

    fun leanBack() {
        Log.d("Command", "I'm leaning back sa commanded")
    }
}


