package com.tiyasinsania0090.beautyglam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.tiyasinsania0090.beautyglam.model.getRecommendedMakeup
import com.tiyasinsania0090.beautyglam.model.MakeupStyle
import com.tiyasinsania0090.beautyglam.ui.screen.input.InputScreen
import com.tiyasinsania0090.beautyglam.ui.screen.result.ResultScreen
import com.tiyasinsania0090.beautyglam.ui.theme.BeautyGlamTheme

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

@Composable
fun MainScreen() {
    var results by remember { mutableStateOf<List<MakeupStyle>?>(null) }

    if (results == null) {
        InputScreen { _, skinType, skinTone, undertone, visualType ->
            results = getRecommendedMakeup(skinType, skinTone, undertone, visualType)
        }
    } else {
        ResultScreen(results!!) {
            results = null
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun MainScreenPreview() {
    BeautyGlamTheme {
        MainScreen()
    }
}
