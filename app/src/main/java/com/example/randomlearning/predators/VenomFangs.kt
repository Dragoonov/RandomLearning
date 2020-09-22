package com.example.randomlearning.predators

import android.util.Log

class VenomFangs: KillingFeature {

    private fun increaseVenom() {
        Log.v("Bridge", "Venom is increased")
    }

    private fun decreaseVenom() {
        Log.v("Bridge", "Venom is decreased")

    }

    private fun showFangs() {
        Log.v("Bridge", "Shows fangs")

    }

    private fun bite() {
        Log.v("Bridge", "Bites")

    }

    override fun attack() {
        showFangs()
        bite()
    }

    override fun deadlyAttack() {
        increaseVenom()
        showFangs()
        bite()
    }

    override fun warningAttack() {
        decreaseVenom()
        showFangs()
        bite()
    }


}