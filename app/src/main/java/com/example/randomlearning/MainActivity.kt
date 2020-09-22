package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val simpleDog: Dog = York()
        val withWings = DogWithWingsDecorator(simpleDog)
        val andJumps = JumpingDogDecorator(withWings)
        val godAlmighty = AlmightyDogDecorator(andJumps)

        godAlmighty.bark()
    }
}

interface Dog {
    fun bark()
}

class York : Dog {
    override fun bark() {
        Log.v("Decorator", "A true bark")
    }
}

abstract class BaseDogDecorator(private val dog: Dog) : Dog {
    override fun bark() {
        dog.bark()
    }
}

class DogWithWingsDecorator(dog: Dog) : BaseDogDecorator(dog) {
    override fun bark() {
        Log.v("Decorator", "Move the wings before the bark")
        super.bark()
    }
}

class JumpingDogDecorator(dog: Dog) : BaseDogDecorator(dog) {

    private fun jump() {
        Log.v("Decorator", "Jump from joy!")
    }

    override fun bark() {
        super.bark()
        jump()
    }
}

class AlmightyDogDecorator(dog: Dog) : BaseDogDecorator(dog) {

    private fun killThePlanet() {
        Log.v("Decorator", "Destroys the earth killing the whole human population")
    }

    override fun bark() {
        super.bark()
        killThePlanet()
    }
}




