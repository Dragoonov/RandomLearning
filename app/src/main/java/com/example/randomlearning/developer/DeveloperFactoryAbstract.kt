package com.example.randomlearning.developer

import com.example.randomlearning.Luxury

abstract class DeveloperFactoryAbstract (
    private var wallsNumber: Int?,
    private var qualityOrder: String?,
    private var tableType: Luxury?,
    private var chairsType: Luxury?,
    private var roofType: Luxury?,
    private var sellerAppearance: Luxury?,
    private var repute: Luxury?): DeveloperFactory {}