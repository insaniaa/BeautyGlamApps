package com.tiyasinsania0090.beautyglam.model

fun getRecommendedMakeup(
    skinType: String,
    skinTone: String,
    undertone: String,
    visualType: String
): List<MakeupStyle> {
    val makeupStyles = listOf(
        MakeupStyle("Glam Girl", listOf("Normal", "Dry"), listOf("Fair", "Medium"), listOf("Cool", "Neutral"), listOf("Low")),
        MakeupStyle("Grunge / Smokey", listOf("Oily", "Combination"), listOf("Medium", "Dark"), listOf("Warm"), listOf("Low", "High")),
        MakeupStyle("Latina", listOf("Combination", "Dry"), listOf("Medium", "Dark"), listOf("Warm", "Neutral"), listOf("High")),
        MakeupStyle("Clean", listOf("Normal", "Oily"), listOf("Fair", "Medium"), listOf("Cool", "Neutral"), listOf("Low")),
        MakeupStyle("Igari", listOf("Dry"), listOf("Fair"), listOf("Cool"), listOf("Low")),
        MakeupStyle("Douyin", listOf("Oily", "Normal"), listOf("Fair", "Medium"), listOf("Neutral", "Warm"), listOf("Low", "High")),
        MakeupStyle("Ulzzang", listOf("Oily", "Normal"), listOf("Fair"), listOf("Cool", "Neutral"), listOf("Low")),
        MakeupStyle("Bayonetta", listOf("Combination", "Normal"), listOf("Medium", "Dark"), listOf("Warm"), listOf("Low")),
        MakeupStyle("Gyaru", listOf("Oily", "Combination"), listOf("Fair", "Medium"), listOf("Warm"), listOf("Low", "High")),
        MakeupStyle("Idol", listOf("Dry", "Normal"), listOf("Fair", "Medium", "Dark"), listOf("Neutral"), listOf("Low")),
        MakeupStyle("Doll", listOf("Dry"), listOf("Fair"), listOf("Cool", "Neutral"), listOf("Low")),
        MakeupStyle("Latte", listOf("Normal", "Combination"), listOf("Medium"), listOf("Warm"), listOf("Low")),
        MakeupStyle("Strawberry", listOf("Dry", "Normal"), listOf("Fair"), listOf("Cool"), listOf("Low")),
        MakeupStyle("Dark Feminim", listOf("Oily", "Combination"), listOf("Dark"), listOf("Warm", "Neutral"), listOf("Low", "High")),
        MakeupStyle("Arabian", listOf("Combination", "Oily"), listOf("Medium", "Dark"), listOf("Warm"), listOf("High")),
        MakeupStyle("Tomie", listOf("Normal"), listOf("Fair", "Medium"), listOf("Cool", "Neutral"), listOf("Low")),
        MakeupStyle("Natural", listOf("All"), listOf("All"), listOf("All"), listOf("Low")),
        MakeupStyle("Y2K", listOf("Oily", "Normal"), listOf("Fair", "Medium"), listOf("Neutral"), listOf("Low", "High"))
    )

    return makeupStyles.filter { style ->
        (style.suitableSkinTypes.contains("All") || style.suitableSkinTypes.contains(skinType)) &&
                (style.suitableSkinTones.contains("All") || style.suitableSkinTones.contains(skinTone)) &&
                (style.suitableUndertones.contains("All") || style.suitableUndertones.contains(undertone)) &&
                (style.suitableVisualTypes.contains("All") || style.suitableVisualTypes.contains(visualType))
    }
}
