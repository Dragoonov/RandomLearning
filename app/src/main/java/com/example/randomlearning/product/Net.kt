package com.example.randomlearning.product

interface Net: Product {
    fun isTorn(): Boolean
}

class FishAndMishNet : Net {
    override fun isTorn(): Boolean {
        return true
    }

    override fun getPrice(): Double {
        return 3.0
    }
}

class SereneWatersNet : Net {

    override fun isTorn(): Boolean {
        return true
    }
    override fun getPrice(): Double {
        return 3.0
    }
}

class WaterfallNet : Net {

    override fun isTorn(): Boolean {
        return false
    }
    override fun getPrice(): Double {
        return 3.0
    }
}