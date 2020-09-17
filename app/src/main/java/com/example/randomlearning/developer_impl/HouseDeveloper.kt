package com.example.randomlearning.developer_impl

import com.example.randomlearning.developer.Developer
import com.example.randomlearning.developer.Product

class HouseDeveloper : Developer() {
    override fun createProduct(): Product {
        return House()
    }
}