package com.tiyasinsania0090.beautyglam.ui.screen.input

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.*
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.saveable.rememberSaveable
import com.tiyasinsania0090.beautyglam.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputScreen(
    onSubmit: (String, String, String, String, String, String) -> Unit,
    onNavigateAbout: () -> Unit
) {
    val context = LocalContext.current
    val skinTypes = listOf("Oily", "Combination", "Dry", "Normal")
    val skinTones = listOf("Fair", "Medium", "Dark")
    val undertones = listOf("Cool", "Neutral", "Warm")
    val visualTypes = listOf("Low", "High")
    val makeupUses = listOf("Daily", "Formal", "Special Events")

    var name by rememberSaveable { mutableStateOf("") }
    var skinType by rememberSaveable { mutableStateOf("") }
    var skinTone by rememberSaveable { mutableStateOf("") }
    var undertone by rememberSaveable { mutableStateOf("") }
    var visualType by rememberSaveable { mutableStateOf("") }
    var makeupUse by rememberSaveable { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("BeautyGlam") },
                actions = {
                    IconButton(onClick = onNavigateAbout) {
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
                .padding(16.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Find Your Makeup!", style = MaterialTheme.typography.titleMedium, color = Color(0xFFE91E63))

            // 🐰 Bunny Image
            Image(
                painter = painterResource(id = R.drawable.loadingbunny),
                contentDescription = "Loading Bunny",
                modifier = Modifier
                    .size(180.dp)
                    .padding(vertical = 16.dp)
            )

            BeautyTextField("Name", name) { name = it }
            SimpleDropdownSelector("Skin Type", skinTypes, skinType) { skinType = it }
            SimpleDropdownSelector("Skin Tone", skinTones, skinTone) { skinTone = it }
            SimpleDropdownSelector("Under Tone", undertones, undertone) { undertone = it }
            SimpleDropdownSelector("Visual Type", visualTypes, visualType) { visualType = it }
            SimpleDropdownSelector("Makeup Uses", makeupUses, makeupUse) { makeupUse = it }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (name.isNotBlank() && skinType.isNotBlank() && skinTone.isNotBlank() &&
                        undertone.isNotBlank() && visualType.isNotBlank() && makeupUse.isNotBlank()) {
                        onSubmit(name, skinType, skinTone, undertone, visualType, makeupUse)
                    } else {
                        Toast.makeText(context, "Please fill all fields 💖", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE91E63))
            ) {
                Text("Check Your Recommendation")
            }
        }
    }
}

@Composable
fun BeautyTextField(label: String, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}

@Composable
fun SimpleDropdownSelector(
    label: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Dropdown Icon")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
