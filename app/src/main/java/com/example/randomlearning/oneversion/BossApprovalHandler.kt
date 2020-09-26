package com.example.randomlearning.oneversion

import android.util.Log

class BossApprovalHandler: BaseHandler() {
    override fun canHandle(visitor: Visitor): Boolean = visitor.haveBossApproval

    override fun handle(visitor: Visitor) {
        if (canHandle(visitor)) {
            Log.d("Chain", "The boss approval is there, signing and passing further")
            nextHandler?.handle(visitor)
        } else {
            Log.d("Chain", "The boss didn't approve, how do you want buy anything without it")
        }
    }
}