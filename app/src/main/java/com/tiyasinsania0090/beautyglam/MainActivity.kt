package com.tiyasinsania0090.beautyglam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.tiyasinsania0090.beautyglam.navigation.AppNavigation
import com.tiyasinsania0090.beautyglam.ui.theme.BeautyGlamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeautyGlamTheme {
                rememberNavController()
                AppNavigation()
            }
        }
    }
}