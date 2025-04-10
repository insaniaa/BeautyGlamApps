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
import androidx.compose.ui.res.stringResource

@Composable
fun SplashScreen(navController: NavController) {

    var dotCount by remember { mutableIntStateOf(1) }

    LaunchedEffect(Unit) {
        delay(2000L)
        repeat(6) {
            delay(500)
            dotCount = (dotCount % 3) + 1
        }

        navController.navigate("input") {
            popUpTo("loading") { inclusive = true }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
                painter = painterResource(id = R.drawable.loadingbunny),
                contentDescription = "Loading Bunny",
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "${stringResource(R.string.loading)}${".".repeat(dotCount)}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFFD63384)
        )
    }
}
