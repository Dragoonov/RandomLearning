package com.example.randomlearning.builder

import com.example.randomlearning.Luxury
import com.example.randomlearning.developer.*

class DeveloperBuilder {

    private var wallsNumber: Int? = null
    private var qualityOrder: String? = null
    private var tableType: Luxury? = null
    private var chairsType: Luxury? = null
    private var roofType: Luxury? = null
    private var sellerAppearance: Luxury? = null
    private var repute: Luxury? = null
    private var quality: Luxury? = null

    fun reset(): DeveloperBuilder {
        quality = null
        repute = null
        sellerAppearance = null
        roofType = null
        chairsType = null
        tableType = null
        qualityOrder = null
        wallsNumber = null
        return this
    }

    fun buildWalls(number: Int): DeveloperBuilder {
        wallsNumber = number
        return this
    }

    fun setQualityOrder(order: String): DeveloperBuilder {
        qualityOrder = order
        return this
    }

    fun setTableType(type: Luxury): DeveloperBuilder {
        tableType = type
        return this
    }

    fun setChairsType(type: Luxury): DeveloperBuilder {
        chairsType = type
        return this
    }

    fun setRoofType(type: Luxury): DeveloperBuilder {
        roofType = type
        return this
    }

    fun setSellerAppearance(type: Luxury): DeveloperBuilder {
        sellerAppearance = type
        return this
    }

    fun setRepute(type: Luxury): DeveloperBuilder {
        repute = type
        return this
    }

    fun setOverallQuality(type: Luxury): DeveloperBuilder {
        quality = type
        return this
    }

    fun getResult(): DeveloperFactory {
        return when (quality) {
            null -> {
                CustomDeveloperFactory(
                    wallsNumber,
                    qualityOrder,
                    tableType,
                    chairsType,
                    roofType,
                    sellerAppearance,
                    repute)
            }
            Luxury.CHEAP -> {
                FishAndMishDeveloperFactory()
            }
            Luxury.MEDIUM -> {
                SereneWatersDeveloperFactory()
            }
            else -> {
                WaterfallDeveloperFactory()
            }
        }
    }
}