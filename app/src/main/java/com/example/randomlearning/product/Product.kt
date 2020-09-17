package com.example.randomlearning.product

interface Product {
    fun getPrice(): Double

    fun getName() = javaClass.simpleName
}
