package com.tiyasinsania0090.beautyglam.ui.screen.result

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tiyasinsania0090.beautyglam.model.MakeupStyle

@Composable
fun ResultScreen(
    results: List<MakeupStyle>,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Recommended Makeup Styles:",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (results.isEmpty()) {
            Text(
                "No suitable makeup style found 😢",
                style = MaterialTheme.typography.bodyLarge
            )
        } else {
            results.forEach { style ->
                Text(
                    text = "- ${style.name} (Skin Types: ${style.suitableSkinTypes.joinToString()})",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onBack) {
            Text("Back")
        }
    }
}
