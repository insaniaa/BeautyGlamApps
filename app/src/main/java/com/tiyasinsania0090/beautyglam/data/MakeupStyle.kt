package com.tiyasinsania0090.beautyglam.data

data class MakeupStyle(
    val name: String,
    val suitableSkinTypes: List<String>,
    val suitableSkinTones: List<String>,
    val suitableUndertones: List<String>,
    val suitableVisualTypes: List<String>,
    val suitableUses: List<String>,
    val imageName: String
)

