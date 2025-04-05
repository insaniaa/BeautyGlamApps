package com.tiyasinsania0090.beautyglam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tiyasinsania0090.beautyglam.ui.screen.input.InputScreen
import com.tiyasinsania0090.beautyglam.ui.screen.result.ResultScreen
import com.tiyasinsania0090.beautyglam.ui.theme.BeautyGlamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeautyGlamTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    BeautyGlamApp()
}

@Composable
fun BeautyGlamApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "input") {
        composable("input") {
            InputScreen(navController)
        }
        composable(
            route = "result/{name}/{skinType}/{skinTone}/{undertone}/{visualType}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("skinType") { type = NavType.StringType },
                navArgument("skinTone") { type = NavType.StringType },
                navArgument("undertone") { type = NavType.StringType },
                navArgument("visualType") { type = NavType.StringType },
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val skinType = backStackEntry.arguments?.getString("skinType") ?: ""
            val skinTone = backStackEntry.arguments?.getString("skinTone") ?: ""
            val undertone = backStackEntry.arguments?.getString("undertone") ?: ""
            val visualType = backStackEntry.arguments?.getString("visualType") ?: ""

            ResultScreen(name, skinType, skinTone, undertone, visualType)
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun MainScreenPreview() {
    BeautyGlamTheme {
        MainScreen()
    }
}
