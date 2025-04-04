package com.tiyasinsania0090.beautyglam

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.tiyasinsania0090.beautyglam.ui.theme.BeautyGlamTheme
import com.tiyasinsania0090.beautyglam.ui.screen.input.InputScreen
import com.tiyasinsania0090.beautyglam.ui.screen.result.ResultScreen

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = "input") {
            composable("input") {
                InputScreen(
                    modifier = Modifier.padding(innerPadding)
                ) { name, skinType, skinTone, undertone, visualType ->
                    navigateToResult(navController, name, skinType, skinTone, undertone, visualType)
                }
            }
            composable(
                route = "result/{name}/{skinType}/{skinTone}/{undertone}/{visualType}",
                arguments = listOf(
                    navArgument("name") { type = NavType.StringType },
                    navArgument("skinType") { type = NavType.StringType },
                    navArgument("skinTone") { type = NavType.StringType },
                    navArgument("undertone") { type = NavType.StringType },
                    navArgument("visualType") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                ResultScreen(
                    name = backStackEntry.arguments?.getString("name") ?: "",
                    skinType = backStackEntry.arguments?.getString("skinType") ?: "",
                    skinTone = backStackEntry.arguments?.getString("skinTone") ?: "",
                    undertone = backStackEntry.arguments?.getString("undertone") ?: "",
                    visualType = backStackEntry.arguments?.getString("visualType") ?: ""
                )
            }
        }
    }
}

/** ✅ Fungsi Navigasi yang Lebih Aman */
fun navigateToResult(
    navController: NavController,
    name: String,
    skinType: String,
    skinTone: String,
    undertone: String,
    visualType: String
) {
    println("Navigating to ResultScreen with: $name, $skinType, $skinTone, $undertone, $visualType")

    val encodedName = Uri.encode(name)
    val encodedSkinType = Uri.encode(skinType)
    val encodedSkinTone = Uri.encode(skinTone)
    val encodedUndertone = Uri.encode(undertone)
    val encodedVisualType = Uri.encode(visualType)

    navController.navigate("result/$encodedName/$encodedSkinType/$encodedSkinTone/$encodedUndertone/$encodedVisualType")
}

@Preview(showBackground = true)
@Preview(uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun MainScreenPreview() {
    BeautyGlamTheme {
        MainScreen()
    }
}