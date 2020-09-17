package com.example.randomlearning.developer_impl

import com.example.randomlearning.developer.Product

class Boat internal constructor(): Product {
    override fun getPrice(): Double = 300.0
}