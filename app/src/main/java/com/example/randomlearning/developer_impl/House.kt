package com.example.randomlearning.developer_impl

import com.example.randomlearning.developer.Product

class House internal constructor(): Product {
    override fun getPrice(): Double = 500000.0
}
