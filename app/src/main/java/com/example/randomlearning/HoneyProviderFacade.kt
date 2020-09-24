package com.example.randomlearning

import com.example.randomlearning.complexsystem.BeeFoodSupplier
import com.example.randomlearning.complexsystem.BeeHoneyPlacer
import com.example.randomlearning.complexsystem.BeeHoneySupplier
import com.example.randomlearning.complexsystem.BeeProducerHoney

class HoneyProviderFacade {
    fun provideHoney(): String {
        BeeFoodSupplier().supplyFood()
        BeeProducerHoney().produceHoney()
        BeeHoneySupplier().supplyHoney()
        BeeHoneyPlacer().placeHoney()
        return "Honey placed on clusters"
    }
}