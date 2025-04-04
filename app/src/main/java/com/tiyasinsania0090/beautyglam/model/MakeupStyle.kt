package com.tiyasinsania0090.beautyglam.model

data class MakeupStyle(
    val name: String,
    val skinType: List<String>, // Oily, Dry, Normal, Combination
    val skinTone: List<String>, // Fair, Medium, Dark
    val undertone: List<String>, // Warm, Neutral, Cool
    val visualType: String // Low atau High
)
