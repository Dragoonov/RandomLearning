package com.example.randomlearning.product

interface Boat: Product {
    fun isLeaking(): Boolean
}

class FishAndMishBoat internal constructor(): Boat {

    override fun isLeaking() = true

    override fun getPrice(): Double = 300.0
}

class SereneWatersBoat internal constructor(): Boat {

    override fun isLeaking() = false

    override fun getPrice(): Double = 350.0
}

class WaterfallBoat internal constructor(): Boat {

    override fun isLeaking() = false

    override fun getPrice(): Double = 400.0
}