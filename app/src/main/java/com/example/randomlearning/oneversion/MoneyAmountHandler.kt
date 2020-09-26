package com.example.randomlearning.oneversion

import android.util.Log

class MoneyAmountHandler: BaseHandler() {
    override fun canHandle(visitor: Visitor): Boolean {
        return visitor.moneyAmount > 5000
    }

    override fun handle(visitor: Visitor) {
        if (canHandle(visitor)) {
            Log.d("Chain", "Ok, you're rich enough. Go to final official")
            nextHandler?.handle(visitor)
        } else {
            Log.d("Chain", "Get out of here, you filthy poor")
        }
    }
}