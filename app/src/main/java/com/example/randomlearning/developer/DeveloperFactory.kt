package com.example.randomlearning.developer

class DeveloperFactory {

    fun provideDeveloper(luxury: LUXURY): Developer =
        when (luxury) {
            LUXURY.CHEAP -> FishAndMishDeveloper()
            LUXURY.MEDIUM -> SereneWatersDeveloper()
            LUXURY.EXPENSIVE -> WaterfallDeveloper()
        }
}

enum class LUXURY {
    CHEAP, MEDIUM, EXPENSIVE
}