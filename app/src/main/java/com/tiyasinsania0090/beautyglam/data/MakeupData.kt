package com.tiyasinsania0090.beautyglam.data

fun getRecommendedMakeup(
    skinType: String,
    skinTone: String,
    undertone: String,
    visualType: String,
    makeupUses: String
): List<MakeupStyle> {
    val makeupStyles = listOf(
        MakeupStyle("Glam Girl", listOf("All"), listOf("All"), listOf("All"), listOf("All"), listOf("All"), "glam"),
        MakeupStyle("Grunge", listOf("All"), listOf("Medium", "Dark"), listOf("Neutral", "Warm"), listOf("All"), listOf("Special Events"), "grunge"),
        MakeupStyle("Latina", listOf("All"), listOf("Medium", "Dark"), listOf("Warm", "Neutral"), listOf("High"), listOf("Formal", "Special Events"), "latina"),
        MakeupStyle("Clean", listOf("All"), listOf("All"), listOf("All"), listOf("Low"), listOf("Formal", "Daily"), "clean"),
        MakeupStyle("Igari", listOf("All"), listOf("All"), listOf("Cool"), listOf("Low"), listOf("Daily", "Special Events"), "igari"),
        MakeupStyle("Douyin", listOf("All"), listOf("All"), listOf("All"), listOf("Low", "High"), listOf("Special Events"), "douyin"),
        MakeupStyle("Ulzzang", listOf("All"), listOf("Fair"), listOf("All"), listOf("Low"), listOf("Daily", "Special Events"), "ulzzang"),
        MakeupStyle("Bayonetta", listOf("All"), listOf("All"), listOf("Warm", "Cool"), listOf("Low"), listOf("Daily", "Special Events"), "bayonetta"),
        MakeupStyle("Gyaru", listOf("All"), listOf("All"), listOf("Warm", "Cool"), listOf("All"), listOf("Special Events"), "gyaru"),
        MakeupStyle("Idol", listOf("Dry", "Normal"), listOf("All"), listOf("All"), listOf("All"), listOf("Special Events"), "idol"),
        MakeupStyle("Doll", listOf("Dry", "Normal"), listOf("All"), listOf("Cool", "Neutral"), listOf("All"), listOf("Special Events"), "doll"),
        MakeupStyle("Latte", listOf("All"), listOf("All"), listOf("Warm"), listOf("All"), listOf("Special Events", "Formal"), "latte"),
        MakeupStyle("Strawberry", listOf("Dry", "Normal"), listOf("All"), listOf("All"), listOf("Low"), listOf("Special Events", "Daily"), "strawberry"),
        MakeupStyle("Dark Feminim", listOf("All"), listOf("All"), listOf("All"), listOf("All"), listOf("Special Events", "Formal"), "darkfeminim"),
        MakeupStyle("Arabian", listOf("All"), listOf("Medium", "Dark"), listOf("Warm"), listOf("High"), listOf("Special Events", "Formal"), "arabian"),
        MakeupStyle("Tomie", listOf("Normal"), listOf("Fair", "Medium"), listOf("Cool", "Neutral"), listOf("Low"), listOf("Special Events", "Daily"), "tomie"),
        MakeupStyle("Natural", listOf("All"), listOf("All"), listOf("All"), listOf("All"), listOf("Daily", "Formal"), "natural"),
        MakeupStyle("Y2K", listOf("All"), listOf("All"), listOf("Neutral", "Cool"), listOf("Low", "High"), listOf("Special Events"), "y2k")
    )
    if (skinType.isEmpty() || skinTone.isEmpty() || undertone.isEmpty() || visualType.isEmpty() || makeupUses.isEmpty()) {
        return emptyList()
    }

    return makeupStyles.filter { style ->
        (style.suitableSkinTypes.contains("All") || style.suitableSkinTypes.contains(skinType)) &&
                (style.suitableSkinTones.contains("All") || style.suitableSkinTones.contains(skinTone)) &&
                (style.suitableUndertones.contains("All") || style.suitableUndertones.contains(undertone)) &&
                (style.suitableVisualTypes.contains("All") || style.suitableVisualTypes.contains(visualType)) &&
                (style.suitableUses.contains("All") || style.suitableUses.contains(makeupUses))
    }
}
