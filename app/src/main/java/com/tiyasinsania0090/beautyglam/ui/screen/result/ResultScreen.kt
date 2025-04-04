package com.tiyasinsania0090.beautyglam.ui.screen.result

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tiyasinsania0090.beautyglam.model.makeupStyles

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(name: String, skinType: String, skinTone: String, undertone: String, visualType: String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Your Makeup Recommendation") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Name: $name", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Skin Type: $skinType", fontSize = 18.sp)
            Text(text = "Skin Tone: $skinTone", fontSize = 18.sp)
            Text(text = "Undertone: $undertone", fontSize = 18.sp)
            Text(text = "Visual Type: $visualType", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(16.dp))

            // Panggil rekomendasi makeup
            RecommendedMakeupList(name, skinType, skinTone, undertone, visualType)
        }
    }
}

@Composable
fun RecommendedMakeupList(name: String, skinType: String, skinTone: String, undertone: String, visualType: String) {
    val recommendedMakeup = makeupStyles.filter { style ->
        style.skinType.equals(skinType) &&
                style.skinTone.equals(skinTone) &&
                style.undertone.equals(undertone) &&
                style.visualType.equals(visualType, true)

    }

    Text(
        text = "Recommendation For You!",
        style = MaterialTheme.typography.headlineMedium
    )
    Spacer(modifier = Modifier.height(8.dp))

    if (recommendedMakeup.isNotEmpty()) {
        Text(text = "Try this, $name!", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(16.dp))
        recommendedMakeup.forEach { makeup ->
            Text(text = "- ${makeup.name}", fontSize = 16.sp)
        }
    } else {
        Text(
            text = "No matching makeup style found.",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun PreviewResultScreen() {
    ResultScreen(
        name = "Tiyas",
        skinType = "Oily",
        skinTone = "Medium",
        undertone = "Warm",
        visualType = "High"
    )
}
