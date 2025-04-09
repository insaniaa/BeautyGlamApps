package com.tiyasinsania0090.beautyglam.ui.screen.loading

import androidx.compose.runtime.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tiyasinsania0090.beautyglam.R
import kotlinx.coroutines.delay
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

@Composable
fun SplashScreen(navController: NavController) {
    var showLogo by remember { mutableStateOf(true) }
    var dotCount by remember { mutableIntStateOf(1) }

    LaunchedEffect(Unit) {
        delay(2000L) // Tampilkan logo 2 detik
        showLogo = false

        // Mulai animasi loading setelah logo
        repeat(6) { // Total: 3 detik (6 x 500ms)
            delay(500)
            dotCount = (dotCount % 3) + 1
        }

        // Navigasi ke Home
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true } // biar splash ga bisa di-back
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLogo) {
            // Logo App (2 detik pertama)
            Image(
                painter = painterResource(id = R.drawable.logobeautyglam),
                contentDescription = "Logo App",
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
            )
        } else {
            // Loading Bunny
            Image(
                painter = painterResource(id = R.drawable.loadingbunny),
                contentDescription = "Loading Bunny",
                modifier = Modifier
                    .height(121.dp)
                    .width(121.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "loading ${".".repeat(dotCount)}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFFEA79A3)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())
}
