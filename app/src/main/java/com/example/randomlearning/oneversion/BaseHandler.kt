package com.example.randomlearning.oneversion

abstract class BaseHandler: Handler {
    protected var nextHandler: Handler? = null

    protected abstract fun canHandle(visitor: Visitor): Boolean

    override fun linkWith(handler: Handler): Handler {
        nextHandler = handler
        return handler
    }
}