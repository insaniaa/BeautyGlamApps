package com.tiyasinsania0090.beautyglam.ui.screen.result

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tiyasinsania0090.beautyglam.model.MakeupStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(
    name: String,
    recommendations: List<MakeupStyle>,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hi $name!", color = Color(0xFF8E24AA)) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFFCE4EC))
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize(),
        ) {
            Text(
                text = "Your recommended makeup styles 💅✨",
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xFFEF5D90)
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(recommendations) { style ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF8BBD0))
                    ) {
                        Text(
                            text = style.name,
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onBack,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8E24AA))
            ) {
                Text("Back", color = Color.White)
            }
        }
    }
}
