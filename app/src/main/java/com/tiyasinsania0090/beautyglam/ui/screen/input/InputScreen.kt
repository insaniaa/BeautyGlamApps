package com.tiyasinsania0090.beautyglam.ui.screen.input

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.tiyasinsania0090.beautyglam.R

@Composable
fun InputScreen(onSubmit: (String, String, String, String, String) -> Unit) {
    val context = LocalContext.current
    val skinTypes = listOf("Oily", "Combination", "Dry", "Normal")
    val skinTones = listOf("Fair", "Medium", "Dark")
    val undertones = listOf("Cool", "Neutral", "Warm")
    val visualTypes = listOf("Low", "High")
    val makeupUses = listOf("Daily", "Formal", "Special Event")

    var name by remember { mutableStateOf("") }
    var skinType by remember { mutableStateOf("") }
    var skinTone by remember { mutableStateOf("") }
    var undertone by remember { mutableStateOf("") }
    var visualType by remember { mutableStateOf("") }
    var makeupUses by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("BeautyGlam") },
                actions = {
                    IconButton(onClick = { /* navigate to About screen */ }) {
                        Icon(Icons.Default.Info, contentDescription = "About")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BeautyTextField("Name", name) { name = it }
            DropdownSelector("Skin Type", skinTypes, skinType) { skinType = it }
            DropdownSelector("Skin Tone", skinTones, skinTone) { skinTone = it }
            DropdownSelector("Under Tone", undertones, undertone) { undertone = it }
            DropdownSelector("Makeup Uses", makeupUses, makeupUses) { makeupUses = it }

            Button(
                onClick = {
                    if (name.isNotBlank() && skinType.isNotBlank() && skinTone.isNotBlank() &&
                        undertone.isNotBlank() && visualType.isNotBlank()
                    ) {
                        onSubmit(name, skinType, skinTone, undertone, visualType)
                    } else {
                        Toast.makeText(context, "Please fill all fields 💖", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ) {
                Text("Check Your Recommendation")
            }
        }
    }
}
