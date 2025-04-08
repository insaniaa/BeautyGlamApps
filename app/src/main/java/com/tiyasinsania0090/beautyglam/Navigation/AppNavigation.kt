package com.tiyasinsania0090.beautyglam.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tiyasinsania0090.beautyglam.ui.screen.loading.SplashScreen
import com.tiyasinsania0090.beautyglam.ui.screen.input.InputScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("loading") {
            SplashScreen(navController)
        }
//        composable("home") {
//            InputScreen(navController) // anggap input screen adalah home
//        }
        // tinggal tambahin: result, about, dll nanti
    }
}
