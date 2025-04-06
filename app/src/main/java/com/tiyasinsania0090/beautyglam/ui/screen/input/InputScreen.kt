package com.tiyasinsania0090.beautyglam.ui.screen.input

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputScreen(onSubmit: (String, String, String, String, String) -> Unit) {
    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var skinType by remember { mutableStateOf("") }
    var skinTone by remember { mutableStateOf("") }
    var undertone by remember { mutableStateOf("") }
    var visualType by remember { mutableStateOf("") }

    val skinTypes = listOf("Oily", "Combination", "Dry", "Normal")
    val skinTones = listOf("Fair", "Medium", "Dark")
    val undertones = listOf("Cool", "Neutral", "Warm")
    val visualTypes = listOf("High", "Low")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Beauty Glam", color = Color(0xFF8E24AA)) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFFCE4EC))
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "This is your makeup recommendation!",
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xFFEF5D90)
            )

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth()
            )

            DropdownSelector("Skin Type", skinTypes, skinType) { skinType = it }
            DropdownSelector("Skin Tone", skinTones, skinTone) { skinTone = it }
            DropdownSelector("Undertone", undertones, undertone) { undertone = it }

            Text("Visual Type", color = Color(0xFF6A1B9A))
            visualTypes.forEach { type ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = visualType == type,
                        onClick = { visualType = type },
                        colors = RadioButtonDefaults.colors(selectedColor = Color(0xFFAB47BC))
                    )
                    Text(type)
                }
            }

            Button(
                onClick = {
                    if (name.isNotBlank() && skinType.isNotBlank() && skinTone.isNotBlank()
                        && undertone.isNotBlank() && visualType.isNotBlank()
                    ) {
                        onSubmit(name, skinType, skinTone, undertone, visualType)
                    } else {
                        Toast.makeText(context, "Please fill all fields 💖", Toast.LENGTH_SHORT).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8E24AA))
            ) {
                Text("Get Recommendation", color = Color.White)
            }

        }
    }
}

@Composable
fun DropdownSelector(label: String, options: List<String>, selected: String, onSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedTextField(
            value = selected,
            onValueChange = { },
            label = { Text(label) },
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { expanded = true }) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Dropdown")
                }
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach {
                DropdownMenuItem(
                    text = { Text(it) },
                    onClick = {
                        onSelected(it)
                        expanded = false
                    }
                )
            }
        }
    }
}
