package com.example.randomlearning.developer

import com.example.randomlearning.Luxury
import com.example.randomlearning.product.*

class FishAndMishDeveloperFactory (
): DeveloperFactoryAbstract(
    2,
    "poor",
    Luxury.CHEAP,
    Luxury.CHEAP,
    Luxury.CHEAP,
    Luxury.CHEAP,
    Luxury.CHEAP
) {

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