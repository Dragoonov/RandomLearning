package com.example.randomlearning.oneversion

import android.util.Log

class LandBuyableHandler: BaseHandler() {
    override fun canHandle(visitor: Visitor): Boolean {
        return visitor.isLandBuyable
    }

    override fun handle(visitor: Visitor) {
        if (canHandle(visitor)) {
            Log.d("Chain", "Goddamn, you have everything right. Here, have your land, tfu!")
        } else {
            Log.d("Chain", "Buahahahaha, your land IS NOT BUYABLE, got to the beggining!!!")
        }
    }
}