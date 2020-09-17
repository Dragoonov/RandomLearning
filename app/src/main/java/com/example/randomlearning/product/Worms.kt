package com.example.randomlearning.product

interface Worms: Product {
    fun areAlive(): Boolean
}

class FishAndMishWorms: Worms {
    override fun getPrice(): Double {
        return 5.0
    }

    override fun areAlive() = false
}

class SereneWatersWorms: Worms {
    override fun getPrice(): Double {
        return 5.0
    }

    override fun areAlive() = false
}

class WaterfallWorms: Worms {
    override fun getPrice(): Double {
        return 5.0
    }

    override fun areAlive() = false
}