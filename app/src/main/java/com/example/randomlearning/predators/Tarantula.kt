package com.example.randomlearning.predators

class Tarantula: Predator {

    private val feature: KillingFeature = VenomFangs()

    override fun kill() {
        feature.deadlyAttack()
    }

    override fun fight() {
        feature.warningAttack()
        feature.attack()
    }
}