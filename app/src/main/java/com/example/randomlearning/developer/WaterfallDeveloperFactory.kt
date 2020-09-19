package com.example.randomlearning.developer

import com.example.randomlearning.Luxury
import com.example.randomlearning.product.*

class WaterfallDeveloperFactory (
) : DeveloperFactoryAbstract(
    4,
    "expensive",
    Luxury.EXPENSIVE,
    Luxury.EXPENSIVE,
    Luxury.EXPENSIVE,
    Luxury.EXPENSIVE,
    Luxury.EXPENSIVE
) {
    override fun provideBoat(): Boat {
        return WaterfallBoat()
    }

    override fun provideNet(): Net{
        return WaterfallNet()
    }

    override fun provideWorms(): Worms {
        return WaterfallWorms()
    }
}