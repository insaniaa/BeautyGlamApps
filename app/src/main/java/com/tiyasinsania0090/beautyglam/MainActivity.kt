package com.tiyasinsania0090.beautyglam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.tiyasinsania0090.beautyglam.model.getRecommendedMakeup
import com.tiyasinsania0090.beautyglam.ui.screen.about.AboutScreen
import com.tiyasinsania0090.beautyglam.ui.screen.input.InputScreen
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
    var recommendations by remember { mutableStateOf(emptyList<com.tiyasinsania0090.beautyglam.model.MakeupStyle>()) }

    NavHost(navController, startDestination = "input") {
        composable("input") {
            InputScreen(
                onSubmit = { name, skinType, skinTone, undertone, visualType ->
                    userName = name
                    recommendations = getRecommendedMakeup(skinType, skinTone, undertone, visualType)
                    navController.navigate("result")
                },
                onNavigateAbout = {
                    navController.navigate("about")
                }
            )
        }
        composable("result") {
            ResultScreen(
                name = userName,
                recommendations = recommendations,
                onBack = { navController.popBackStack() }
            )
        }
        composable("about") {
            AboutScreen()
        }
    }
}
