package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val serene = SereneChild()
        val angry = AngryChild()
        val indifferent = IndifferentChild()
        val toy = RobotToy()

        serene.takeToy(toy)
        angry.takeToy(toy)
        indifferent.takeToy(toy)
    }
}
interface ToyVisitor {
    fun reactOnChild(angryChild: AngryChild)
    fun reactOnChild(sereneChild: SereneChild)
    fun reactOnChild(indifferentChild: IndifferentChild)
}

class RobotToy: ToyVisitor {
    override fun reactOnChild(angryChild: AngryChild) {
        Log.d("Visitor", "Hey, calm down or I'll smack you in the ass you ${angryChild.javaClass.simpleName}")
    }

    override fun reactOnChild(indifferentChild: IndifferentChild) {
        Log.d("Visitor", "Say something, what you have your mouth for, you ${indifferentChild.javaClass.simpleName}?")
    }

    override fun reactOnChild(sereneChild: SereneChild) {
        Log.d("Visitor", "Why so peaceful? I'll kill your mother, you ${sereneChild.javaClass.simpleName}!")

    }

}

interface Child {
    fun takeToy(toy: ToyVisitor)
}

class SereneChild: Child {
    override fun takeToy(toy: ToyVisitor) {
        toy.reactOnChild(this)
    }
}

class AngryChild: Child {
    override fun takeToy(toy: ToyVisitor) {
        toy.reactOnChild(this)
    }
}

class IndifferentChild: Child {
    override fun takeToy(toy: ToyVisitor) {
        toy.reactOnChild(this)
    }
}
