package com.example.randomlearning.oneversion

import android.util.Log

class GrandmaApprovalHandler: BaseHandler() {
    override fun canHandle(visitor: Visitor): Boolean {
        return visitor.haveGrandmaApproval
    }

    override fun handle(visitor: Visitor) {
        if (canHandle(visitor)) {
            Log.d("Chain", "Grandma approved, all right. Passing further")
            nextHandler?.handle(visitor)
        } else {
            Log.d("Chain", "How do you feel hiding it before your grandma?!")
        }
    }
}