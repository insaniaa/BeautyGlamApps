package com.tiyasinsania0090.beautyglam.ui.screen.result

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tiyasinsania0090.beautyglam.model.makeupStyles

@Composable
fun ResultScreen(
    name: String,
    skinType: String,
    skinTone: String,
    undertone: String,
    visualType: String
) {
    val matchedStyle = makeupStyles.find {
        it.skinType.equals(skinType, ignoreCase = true) &&
                it.skinTone.equals(skinTone, ignoreCase = true) &&
                it.undertone.equals(undertone, ignoreCase = true) &&
                it.visualType.equals(visualType, ignoreCase = true)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        if (matchedStyle != null) {
            Text("Hi $name!", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Recommended Makeup Style:", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(8.dp))
            Text("- ${matchedStyle.styleName}", fontSize = 16.sp)
        } else {
            Text("Sorry $name, we couldn't find a matching makeup style.")
        }
    }
}