package com.tiyasinsania0090.beautyglam.ui.screen.input

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun InputScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var skinType by remember { mutableStateOf("") }
    var skinTone by remember { mutableStateOf("") }
    var undertone by remember { mutableStateOf("") }
    var visualType by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Enter your name:", fontSize = 18.sp)
        OutlinedTextField(value = name, onValueChange = { name = it })

        Spacer(modifier = Modifier.height(12.dp))
        Text("Skin Type:")
        OutlinedTextField(value = skinType, onValueChange = { skinType = it })

        Spacer(modifier = Modifier.height(12.dp))
        Text("Skin Tone:")
        OutlinedTextField(value = skinTone, onValueChange = { skinTone = it })

        Spacer(modifier = Modifier.height(12.dp))
        Text("Undertone:")
        OutlinedTextField(value = undertone, onValueChange = { undertone = it })

        Spacer(modifier = Modifier.height(12.dp))
        Text("Visual Type:")
        OutlinedTextField(value = visualType, onValueChange = { visualType = it })

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("result/$name/$skinType/$skinTone/$undertone/$visualType")
        }) {
            Text("See Recommendation")
        }
    }
}