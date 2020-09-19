package com.example.randomlearning.developer

import com.example.randomlearning.Luxury
import com.example.randomlearning.product.Boat
import com.example.randomlearning.product.Net
import com.example.randomlearning.product.Worms

class CustomDeveloperFactory(
    wallsNumber: Int?,
    qualityOrder: String?,
    tableType: Luxury?,
    chairsType: Luxury?,
    roofType: Luxury?,
    sellerAppearance: Luxury?,
    repute: Luxury?
): DeveloperFactoryAbstract(
    wallsNumber,
    qualityOrder,
    tableType,
    chairsType,
    roofType,
    sellerAppearance,
    repute
)  {
    override fun provideBoat(): Boat {
        TODO("Not yet implemented")
    }

    override fun provideNet(): Net {
        TODO("Not yet implemented")
    }

    override fun provideWorms(): Worms {
        TODO("Not yet implemented")
    }
}