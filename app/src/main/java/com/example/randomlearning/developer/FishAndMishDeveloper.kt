package com.example.randomlearning.developer

import com.example.randomlearning.developer.Developer
import com.example.randomlearning.product.*

class FishAndMishDeveloper: Developer {
    override fun provideBoat(): Boat {
        return FishAndMishBoat()
    }

    override fun provideNet(): Net {
        return FishAndMishNet()
    }

    override fun provideWorms(): Worms {
        return FishAndMishWorms()
    }
}