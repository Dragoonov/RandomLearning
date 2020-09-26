package com.example.randomlearning.oneversion

interface Handler {
    fun handle(visitor: Visitor)
    fun linkWith(handler: Handler): Handler
}