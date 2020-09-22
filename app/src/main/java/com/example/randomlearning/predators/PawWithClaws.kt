package com.example.randomlearning.predators

import android.util.Log

class PawWithClaws: KillingFeature {

    private fun showClaws() {
        Log.v("Bridge", "Shows claws")

    }

    private fun swipe() {
        Log.v("Bridge", "Swipes")

    }

    private fun increaseSwipeStrength() {
        Log.v("Bridge", "Swipe is increased")

    }

    private fun decreaseSwipeStrength() {
        Log.v("Bridge", "Swipe is decreased")

    }

    override fun attack() {
        showClaws()
        swipe()
    }

    override fun deadlyAttack() {
        increaseSwipeStrength()
        showClaws()
        swipe()
    }

    override fun warningAttack() {
        decreaseSwipeStrength()
        showClaws()
        swipe()
    }
}