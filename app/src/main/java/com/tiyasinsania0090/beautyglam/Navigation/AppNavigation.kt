package com.tiyasinsania0090.beautyglam.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tiyasinsania0090.beautyglam.ui.screen.loading.SplashScreen
import com.tiyasinsania0090.beautyglam.ui.screen.input.InputScreen
import com.tiyasinsania0090.beautyglam.ui.screen.result.ResultScreen
import com.tiyasinsania0090.beautyglam.ui.screen.about.AboutScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "loading"
    ) {
        composable("loading") {
            SplashScreen(navController = navController) // Navigating to InputScreen
        }
        composable("input") {
            InputScreen(
                onSubmit = { name, skinType, skinTone, undertone, visualType ->
                    // After input, navigate to result screen
                    navController.navigate("result")
                },
                onNavigateAbout = {
                    // Navigate to About Screen
                    navController.navigate("about")
                }
            )
        }
        composable("result") {
            ResultScreen(
                userName = "User", // Customize to pass actual user data
                makeupStyle = com.tiyasinsania0090.beautyglam.data.MakeupStyle("MakeupStyle", emptyList(), emptyList(), emptyList(), emptyList(), emptyList(), "imageName"),
                onNext = {
                    navController.navigate("input") // Navigate back to input after result
                },
                onBack = {
                    navController.popBackStack() // Navigate back to previous screen
                }
            )
        }
        composable("about") {
            AboutScreen(navController = navController) // Navigate to About Screen
        }
    }
}
