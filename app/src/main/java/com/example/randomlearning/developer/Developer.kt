package com.example.randomlearning.developer

abstract class Developer {

    fun develop() = createProduct()

    protected abstract fun createProduct(): Product
}