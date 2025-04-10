package com.tiyasinsania0090.beautyglam.data

data class MakeupStyle(
    val imageName: String,
    val suitableSkinTypes: List<String>,
    val suitableSkinTones: List<String>,
    val suitableUndertones: List<String>,
    val suitableVisualTypes: List<String>,
    val suitableUses: List<String>,
    val styleCode: String
)
