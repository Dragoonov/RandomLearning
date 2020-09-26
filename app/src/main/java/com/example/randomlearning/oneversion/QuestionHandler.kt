package com.example.randomlearning.oneversion

import android.util.Log

class QuestionHandler: BaseHandler() {
    override fun canHandle(visitor: Visitor): Boolean =
        visitor.question == "Can I buy some land"

    override fun handle(visitor: Visitor) {
        if (canHandle(visitor)) {
            Log.d("Chain","Visitor came with a proper question. Signing some documents and sending him to next handler")
            nextHandler?.handle(visitor)
        } else {
            Log.d("Chain", "I think you've mistaken institutions")
        }
    }
}