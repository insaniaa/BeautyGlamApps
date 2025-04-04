package com.tiyasinsania0090.beautyglam.ui.screen.input

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp

@Composable
fun InputScreen(
    modifier: Modifier = Modifier,
    onSubmit: (String, String, String, String, String) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var selectedSkinType by remember { mutableStateOf("") }
    var selectedSkinTone by remember { mutableStateOf("") }
    var selectedUndertone by remember { mutableStateOf("") }
    var selectedVisualType by remember { mutableStateOf("") }

    val skinTypes = listOf("Oily", "Dry", "Combination", "Normal")
    val skinTones = listOf("Fair", "Medium", "Dark")
    val undertones = listOf("Warm", "Neutral", "Cool")
    val visualTypes = listOf("Low", "Medium", "High")

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Check your makeup for today!", style = MaterialTheme.typography.headlineMedium)

        // Input Nama
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
            modifier = Modifier.fillMaxWidth()
        )

        // Dropdown Pilihan
        selectedSkinType = dropdownmenufield("Skin Type", skinTypes, selectedSkinType)
        selectedSkinTone = dropdownmenufield("Skin Tone", skinTones, selectedSkinTone)
        selectedUndertone = dropdownmenufield("Undertone", undertones, selectedUndertone)
        selectedVisualType = dropdownmenufield("Visual Type", visualTypes, selectedVisualType)

        // Tombol Submit
        Button(
            onClick = {
                onSubmit(name, selectedSkinType, selectedSkinTone, selectedUndertone, selectedVisualType)
            },
            enabled = name.isNotBlank() && selectedSkinType.isNotBlank() &&
                    selectedSkinTone.isNotBlank() && selectedUndertone.isNotBlank() && selectedVisualType.isNotBlank()
        ) {
            Text(text = "Check Here!")
        }
    }
}

@Composable
fun dropdownmenufield(label: String, options: List<String>, selectedOption: String): String {
    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf(selectedOption) }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = label, style = MaterialTheme.typography.bodyLarge)
        Box {
            OutlinedButton(
                onClick = { expanded = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = selected.ifEmpty { "Choose $label" })
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selected = option // Memperbarui nilai dropdown
                            expanded = false
                        }
                    )
                }
            }
        }
    }
    return selected // Mengembalikan nilai yang dipilih
}
