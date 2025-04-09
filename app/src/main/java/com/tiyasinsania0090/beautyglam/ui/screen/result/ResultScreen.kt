package com.tiyasinsania0090.beautyglam.ui.screen.result

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tiyasinsania0090.beautyglam.data.MakeupStyle

@Composable
fun ResultScreen(
    userName: String,
    makeupStyle: MakeupStyle,
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello, $userName!",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFD63384),
        )

        Text(
            text = "You can try this makeup style today! ><",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Display makeup style image list
        LazyRow(
            contentPadding = PaddingValues(horizontal = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        ) {
            items(listOf(makeupStyle.imageName)) { imageName ->
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(6.dp),
                    modifier = Modifier
                        .width(160.dp)
                        .fillMaxHeight()
                ) {
                    Image(
                        painter = painterResource(id = resources.getIdentifier(imageName, "drawable", packageName)),
                        contentDescription = "Makeup style image",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Adding both the Back and Next buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { onBack() },
                modifier = Modifier.weight(1f)
            ) {
                Text("Back")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = { onNext() },
                modifier = Modifier.weight(1f)
            ) {
                Text("Next")
            }
        }
    }
}
