package com.tiyasinsania0090.beautyglam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.tiyasinsania0090.beautyglam.navigation.AppNavigation
import com.tiyasinsania0090.beautyglam.data.getRecommendedMakeup
import com.tiyasinsania0090.beautyglam.ui.screen.result.ResultScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeautyGlamApp()
        }
    }
}

@Composable
fun BeautyGlamApp() {
    val navController = rememberNavController()

    var userName by remember { mutableStateOf("") }
    var recommendations by remember { mutableStateOf(emptyList<com.tiyasinsania0090.beautyglam.data.MakeupStyle>()) }
    var currentRecommendationIndex by remember { mutableStateOf(0) }

    NavHost(navController, startDestination = "input") {
        composable("input") {
            InputScreen(
                onSubmit = { name, skinType, skinTone, undertone, visualType ->
                    userName = name
                    recommendations = getRecommendedMakeup(skinType, skinTone, undertone, visualType)
                    navController.navigate("result")
                }
            )
        }
        composable("result") {
            ResultScreen(
                userName = userName,
                makeupStyle = recommendations.getOrElse(currentRecommendationIndex) { recommendations.firstOrNull() ?: com.tiyasinsania0090.beautyglam.data.MakeupStyle("None", emptyList(), emptyList(), emptyList(), emptyList(), emptyList(), "") },
                onNext = {
                    if (currentRecommendationIndex < recommendations.size - 1) {
                        currentRecommendationIndex++
                    }
                },
                onBack = {
                    if (currentRecommendationIndex > 0) {
                        currentRecommendationIndex--
                    }
                }
            )
        }
    }
}
