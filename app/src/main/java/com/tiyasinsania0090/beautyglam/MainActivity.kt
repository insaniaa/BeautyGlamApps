package com.tiyasinsania0090.beautyglam

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tiyasinsania0090.beautyglam.ui.theme.BeautyGlamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BeautyGlamTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        }
    ) { innerPadding ->
        InputScreen(Modifier.padding(innerPadding))
    }
}

@Composable
fun InputScreen(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var selectedSkinType by remember { mutableStateOf("") }
    var selectedSkinTone by remember { mutableStateOf("") }
    var selectedUndertone by remember { mutableStateOf("") }
    var selectedVisualType by remember { mutableStateOf("") }

    val skinTypes = listOf("Oily", "Dry", "Combination", "Normal")
    val skinTones = listOf("Fair", "Medium", "Dark")
    val undertones = listOf("Warm", "Neutral", "Cool")
    val visualTypes = listOf("Low", "High")

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Masukkan Data Anda", style = MaterialTheme.typography.headlineMedium)

        // Input Nama
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nama") }
        )

        // Dropdown Pilihan
        DropdownMenuField("Tipe Kulit", skinTypes, selectedSkinType) { selectedSkinType = it }
        DropdownMenuField("Warna Kulit", skinTones, selectedSkinTone) { selectedSkinTone = it }
        DropdownMenuField("Undertone", undertones, selectedUndertone) { selectedUndertone = it }
        DropdownMenuField("Jenis Visual", visualTypes, selectedVisualType) { selectedVisualType = it }

        // Tombol Submit (Nanti bisa navigasi ke hasil)
        Button(onClick = {
            // TODO: Arahkan ke halaman hasil dengan data yang dipilih
        }) {
            Text(text = "Cari Rekomendasi Makeup")
        }
    }
}

@Composable
fun DropdownMenuField(label: String, options: List<String>, selectedOption: String, onSelectionChange: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        Text(text = label, style = MaterialTheme.typography.bodyLarge)
        Box {
            OutlinedButton(onClick = { expanded = true }) {
                Text(text = if (selectedOption.isEmpty()) "Pilih $label" else selectedOption)
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            onSelectionChange(option)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun MainScreenPreview() {
    BeautyGlamTheme {
        MainScreen()
    }
}
