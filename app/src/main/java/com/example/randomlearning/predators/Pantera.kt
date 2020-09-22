package com.example.randomlearning.predators

class Pantera(private val feature: KillingFeature): Predator {

    override fun kill() {
        feature.deadlyAttack()
    }

    override fun fight() {
        feature.attack()
        feature.attack()
    }
}