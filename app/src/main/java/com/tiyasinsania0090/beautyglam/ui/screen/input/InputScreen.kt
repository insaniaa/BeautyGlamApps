package com.tiyasinsania0090.beautyglam.ui.screen.input

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
import androidx.compose.ui.res.stringResource
import com.tiyasinsania0090.beautyglam.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputScreen(
    onSubmit: (String, String, String, String, String, String) -> Unit,
    onNavigateAbout: () -> Unit
) {
    LocalContext.current
    val skinTypes = listOf("Oily", "Combination", "Dry", "Normal")
    val skinTones = listOf("Fair", "Medium", "Dark")
    val undertones = listOf("Cool", "Neutral", "Warm")
    val visualTypes = listOf("Low", "High")
    val makeupUses = listOf("Daily", "Formal", "Special Events")

    var name by rememberSaveable { mutableStateOf("") }
    var nameError by rememberSaveable { mutableStateOf(false) }

    var skinType by rememberSaveable { mutableStateOf("") }
    var skinTypeError by rememberSaveable { mutableStateOf(false) }

    var skinTone by rememberSaveable { mutableStateOf("") }
    var skinToneError by rememberSaveable { mutableStateOf(false) }

    var undertone by rememberSaveable { mutableStateOf("") }
    var undertoneError by rememberSaveable { mutableStateOf(false) }

    var visualType by rememberSaveable { mutableStateOf("") }
    var visualTypeError by rememberSaveable { mutableStateOf(false) }

    var makeupUse by rememberSaveable { mutableStateOf("") }
    var makeupUseError by rememberSaveable { mutableStateOf(false) }

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

            BeautyTextField(
                label = "Name",
                error = nameError,
                value = name,
                onValueChange = { name = it }
            )
            SimpleDropdownSelector("Skin Type", error = skinTypeError, skinTypes, skinType) { skinType = it }
            SimpleDropdownSelector("Skin Tone", error = skinToneError, skinTones, skinTone) { skinTone = it }
            SimpleDropdownSelector("Under Tone", error = undertoneError, undertones, undertone) { undertone = it }
            SimpleDropdownSelector("Visual Type", error = visualTypeError, visualTypes, visualType) { visualType = it }
            SimpleDropdownSelector("Makeup Uses", error = makeupUseError, makeupUses, makeupUse) { makeupUse = it }

            Spacer(modifier = Modifier.height(4.dp))

            Button(
                onClick = {
                    nameError = (name == "" || name == "0" )
                    skinTypeError = (skinType == "" || skinType == "0" )
                    skinToneError = (skinTone == "" || skinTone == "0" )
                    undertoneError = (undertone == "" || undertone == "0" )
                    visualTypeError = (visualType == "" || visualType == "0" )
                    makeupUseError = (makeupUse == "" || makeupUse == "0" )
                    if (nameError || skinTypeError || skinToneError || undertoneError || visualTypeError || makeupUseError) {
                        return@Button
                    } else if (name.isNotBlank() && skinType.isNotBlank() && skinTone.isNotBlank() &&
                        undertone.isNotBlank() && visualType.isNotBlank() && makeupUse.isNotBlank()) {
                        onSubmit(name, skinType, skinTone, undertone, visualType, makeupUse)
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
fun BeautyTextField(label: String, error: Boolean, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        supportingText = { ErrorHint(isError = error) },
        isError = error,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}

@Composable
fun SimpleDropdownSelector(
    label: String,
    error: Boolean,
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
            supportingText = { ErrorHint(isError = error) },
            isError = error,
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

@Composable
fun ErrorHint(isError: Boolean) {
    if (isError) {
        Text(text = stringResource(R.string.input_invalid))
    }
}
