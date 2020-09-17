package com.example.randomlearning.developer

import com.example.randomlearning.product.*

class SereneWatersDeveloper: Developer {
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