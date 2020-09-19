package com.example.randomlearning.developer

import com.example.randomlearning.Luxury
import com.example.randomlearning.product.*

class SereneWatersDeveloperFactory (
) : DeveloperFactoryAbstract(
    3,
    "medium",
    Luxury.CHEAP,
    Luxury.MEDIUM,
    Luxury.MEDIUM,
    Luxury.EXPENSIVE,
    Luxury.MEDIUM
) {
    override fun provideBoat(): Boat {
        return SereneWatersBoat()
    }

    override fun provideNet(): Net {
        return SereneWatersNet()
    }

    override fun provideWorms(): Worms {
        return SereneWatersWorms()
    }
}