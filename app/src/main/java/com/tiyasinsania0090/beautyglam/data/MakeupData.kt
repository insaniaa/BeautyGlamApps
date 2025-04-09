package com.tiyasinsania0090.beautyglam.data

fun getRecommendedMakeup(
    skinType: String,
    skinTone: String,
    undertone: String,
    visualType: String,
    makeupUses: String
): List<MakeupStyle> {
    val makeupStyles = listOf(
        MakeupStyle("Glam Girl", listOf("Normal", "Dry"), listOf("Fair", "Medium", "Dark"), listOf("Cool", "Neutral", "Warm"), listOf("Low"), listOf("Daily", "Formal", "Special Events"), "glam.jpg"),
        MakeupStyle("Grunge", listOf("Dry", "Normal", "Combination", "Oily"), listOf("Medium", "Dark"), listOf("Neutral", "Warm"), listOf("Low", "High"), listOf("Special Events"), "grunge.jpg"),
        MakeupStyle("Latina", listOf("Normal", "Oily", "Combination", "Dry"), listOf("Medium", "Dark"), listOf("Warm", "Neutral"), listOf("High"), listOf("Formal", "Special Events"), "latina.jpg"),
        MakeupStyle("Clean", listOf("Dry", "Combination", "Normal", "Oily"), listOf("Fair", "Medium", "Dark"), listOf("Cool", "Neutral", "Warm"), listOf("Low"), listOf("Formal", "Daily"), "clean.jpg"),
        MakeupStyle("Igari", listOf("Dry", "Normal", "Combination", "Oily"), listOf("Fair", "Medium", "Dark"), listOf("Cool"), listOf("Low"), listOf("Daily", "Special Events"), "igari.jpg"),
        MakeupStyle("Douyin", listOf("Dry", "Normal", "Combination", "Oily"), listOf("Fair", "Medium", "Dark"), listOf("Cool", "Neutral", "Warm"), listOf("Low", "High"), listOf("Special Events"), "douyin.jpg"),
        MakeupStyle("Ulzzang", listOf("Dry", "Normal", "Combination", "Oily"), listOf("Fair"), listOf("Cool", "Neutral", "Warm"), listOf("Low"), listOf("Daily", "Special Events"), "ulzzang.jpg"),
        MakeupStyle("Bayonetta", listOf("Dry", "Normal", "Combination", "Oily"), listOf("Fair", "Medium", "Dark"), listOf("Warm", "Cool"), listOf("Low"), listOf("Daily", "Special Events"), "bayonetta.jpg"),
        MakeupStyle("Gyaru", listOf("Dry", "Normal", "Combination", "Oily"), listOf("Fair", "Medium", "Dark"), listOf("Warm", "Cool"), listOf("Low", "High"), listOf("Special Events"), "gurau.jpg"),
        MakeupStyle("Idol", listOf("Dry", "Normal"), listOf("Fair", "Medium", "Dark"), listOf("Warm", "Cool", "Neutral"), listOf("Low"), listOf("Special Events"), "idol.jpg"),
        MakeupStyle("Doll", listOf("Dry", "Normal"), listOf("Fair", "Medium", "Dark"), listOf("Cool", "Neutral"), listOf("Low"), listOf("Special Events"), "doll.jpg"),
        MakeupStyle("Latte", listOf("Dry", "Normal", "Combination", "Oily"), listOf("Fair", "Medium", "Dark"), listOf("Warm"), listOf("Low", "High"), listOf("Special Events", "Formal"), "latte.jpg"),
        MakeupStyle("Strawberry", listOf("Dry", "Normal"), listOf("Fair", "Medium", "Dark"), listOf("Cool", "Medium", "Warm"), listOf("Low"), listOf("Special Events", "Daily"), "strawberry.jpg"),
        MakeupStyle("Dark Feminim", listOf("Dry", "Normal", "Combination", "Oily"), listOf("Fair", "Medium", "Dark"), listOf("Cool", "Warm", "Neutral"), listOf("Low", "High"), listOf("Special Events", "Formal"), "darkfeminim.jpg"),
        MakeupStyle("Arabian", listOf("All"), listOf("Medium", "Dark"), listOf("Warm"), listOf("High"), listOf("Special Events", "Formal"), "arabian.jpg"),
        MakeupStyle("Tomie", listOf("Normal"), listOf("Fair", "Medium"), listOf("Cool", "Neutral"), listOf("Low"), listOf("Special Events", "Daily"), "tomie.jpg"),
        MakeupStyle("Natural", listOf("All"), listOf("All"), listOf("All"), listOf("Low"), listOf("Daily", "Formal"), "natural.jpg"),
        MakeupStyle("Y2K", listOf("All"), listOf("All"), listOf("Neutral", "Cool"), listOf("Low", "High"), listOf("Special Events"), "y2k.jpg")
    )

    return makeupStyles.filter { style ->
        (style.suitableSkinTypes.contains("All") || style.suitableSkinTypes.contains(skinType)) &&
                (style.suitableSkinTones.contains("All") || style.suitableSkinTones.contains(skinTone)) &&
                (style.suitableUndertones.contains("All") || style.suitableUndertones.contains(undertone)) &&
                (style.suitableVisualTypes.contains("All") || style.suitableVisualTypes.contains(visualType)) &&
                (style.suitableUses.contains("All") || style.suitableUses.contains(makeupUses))
    }
}

