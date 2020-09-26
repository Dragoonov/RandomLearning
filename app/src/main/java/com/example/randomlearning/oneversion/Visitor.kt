package com.example.randomlearning.oneversion

data class Visitor(
    val question: String = "Can I buy some land",
    val haveBossApproval: Boolean = true,
    val haveGrandmaApproval: Boolean = true,
    val moneyAmount: Int = 10000,
    val isLandBuyable: Boolean = true
)