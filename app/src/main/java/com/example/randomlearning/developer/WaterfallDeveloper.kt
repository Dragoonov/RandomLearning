package com.example.randomlearning.developer

import com.example.randomlearning.product.*

class WaterfallDeveloper: Developer {
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