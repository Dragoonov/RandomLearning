package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.randomlearning.developer.DeveloperFactory
import com.example.randomlearning.developer.LUXURY

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val factory = DeveloperFactory()
        val iWantCheapProducts = factory.provideDeveloper(LUXURY.CHEAP)
        val hmmmWhatBoatCanIGet = iWantCheapProducts.provideBoat()
        Log.v("Main", hmmmWhatBoatCanIGet.getName() + " is leaking?: " + hmmmWhatBoatCanIGet.isLeaking())
        val andIAmASelfishBusinessman = factory.provideDeveloper(LUXURY.EXPENSIVE)
        val iWantBestNetSoiCanThinkIAmBetterthanOthers = andIAmASelfishBusinessman.provideNet()
        Log.v("Main", iWantBestNetSoiCanThinkIAmBetterthanOthers.getName() + " is leaking?: " +
                iWantBestNetSoiCanThinkIAmBetterthanOthers.isTorn())

    }
}
