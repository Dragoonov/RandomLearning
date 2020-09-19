package com.example.randomlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.randomlearning.builder.DeveloperBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val builder = DeveloperBuilder()
        val iWantCheapProducts = builder.reset().setOverallQuality(Luxury.CHEAP).getResult()
        val hmmmWhatBoatCanIGet = iWantCheapProducts.provideBoat()
        Log.v("Main", hmmmWhatBoatCanIGet.getName() + " is leaking?: " + hmmmWhatBoatCanIGet.isLeaking())
        val andIAmASelfishBusinessman = builder.reset().setOverallQuality(Luxury.EXPENSIVE).getResult()
        val iWantBestNetSoiCanThinkIAmBetterthanOthers = andIAmASelfishBusinessman.provideNet()
        Log.v("Main", iWantBestNetSoiCanThinkIAmBetterthanOthers.getName() + " is leaking?: " +
                iWantBestNetSoiCanThinkIAmBetterthanOthers.isTorn())

        val getMeCustom = builder
            .reset()
            .buildWalls(8)
            .setChairsType(Luxury.MEDIUM)
            .setQualityOrder("Gutted Fish Order")
            .setRoofType(Luxury.EXPENSIVE)
            .setTableType(Luxury.CHEAP)
            .setRepute(Luxury.CHEAP)
            .setSellerAppearance(Luxury.EXPENSIVE)
            .setRoofType(Luxury.MEDIUM)
            .getResult()

        Log.v("Main", getMeCustom.toString())
    }
}
