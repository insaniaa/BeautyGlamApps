package com.tiyasinsania0090.beautyglam.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tiyasinsania0090.beautyglam.data.getRecommendedMakeup
import com.tiyasinsania0090.beautyglam.ui.screen.about.AboutScreen
import com.tiyasinsania0090.beautyglam.ui.screen.input.InputScreen
import com.tiyasinsania0090.beautyglam.ui.screen.result.ResultScreen
import com.tiyasinsania0090.beautyglam.ui.screen.loading.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "loading") {
        composable("loading") {
            SplashScreen(navController = navController)
        }

        composable("input") {
            InputScreen(
                onSubmit = { name, skinType, skinTone, undertone, visualType, makeupUses ->
                    navController.navigate("result/$name/$skinType/$skinTone/$undertone/$visualType/$makeupUses")
                },
                onNavigateAbout = {
                    navController.navigate("about")
                }
            )
        }

        composable(
            "result/{name}/{skinType}/{skinTone}/{undertone}/{visualType}/{makeupUses}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("skinType") { type = NavType.StringType },
                navArgument("skinTone") { type = NavType.StringType },
                navArgument("undertone") { type = NavType.StringType },
                navArgument("visualType") { type = NavType.StringType },
                navArgument("makeupUses") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val skinType = backStackEntry.arguments?.getString("skinType") ?: ""
            val skinTone = backStackEntry.arguments?.getString("skinTone") ?: ""
            val undertone = backStackEntry.arguments?.getString("undertone") ?: ""
            val visualType = backStackEntry.arguments?.getString("visualType") ?: ""
            val makeupUses = backStackEntry.arguments?.getString("makeupUses") ?: ""

            val recommended =
                getRecommendedMakeup(skinType, skinTone, undertone, visualType, makeupUses)

            ResultScreen(
                userName = name,
                recommendedStyles = recommended,
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable("about") {
            AboutScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
