package com.tiyasinsania0090.beautyglam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tiyasinsania0090.beautyglam.ui.theme.BeautyGlamTheme
import com.tiyasinsania0090.beautyglam.ui.screen.input.InputScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
    var userData by remember { mutableStateOf("") }

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
        InputScreen(modifier = Modifier.padding(innerPadding)) { name, skinType, skinTone, undertone, visualType ->
            generateMakeupRecommendation(name, skinType, skinTone, undertone, visualType) { result ->
                userData = result
            }
        }

        // Jika ingin menampilkan hasil di UI:
        if (userData.isNotEmpty()) {
            Text(text = userData, modifier = Modifier.padding(16.dp))
        }
    }
}

fun generateMakeupRecommendation(
    name: String,
    skinType: String,
    skinTone: String,
    undertone: String,
    visualType: String,
    onResult: (String) -> Unit
) {
    val result = """
        User: $name
        Skin Type: $skinType
        Skin Tone: $skinTone
        Undertone: $undertone
        Visual Type: $visualType
    """.trimIndent()

    onResult(result) // Mengupdate state di MainScreen()
}

@Preview(showBackground = true)
@Preview(uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun MainScreenPreview() {
    BeautyGlamTheme {
        MainScreen()
    }
}
