package com.example.randomlearning.developer

import com.example.randomlearning.product.Boat
import com.example.randomlearning.product.Net
import com.example.randomlearning.product.Product
import com.example.randomlearning.product.Worms

interface DeveloperFactory {

    fun provideBoat(): Boat
    fun provideNet(): Net
    fun provideWorms(): Worms
}