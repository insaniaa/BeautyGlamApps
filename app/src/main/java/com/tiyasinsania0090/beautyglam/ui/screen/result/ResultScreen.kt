package com.tiyasinsania0090.beautyglam.ui.screen.result

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tiyasinsania0090.beautyglam.R
import com.tiyasinsania0090.beautyglam.data.MakeupStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(
    userName: String,
    recommendedStyles: List<MakeupStyle>,
    onBack: () -> Unit,
) {
    LocalContext.current

    val styleMap = mapOf(
        "glam" to R.drawable.glam,
        "grunge" to R.drawable.grunge,
        "latina" to R.drawable.latina,
        "clean" to R.drawable.clean,
        "igari" to R.drawable.igari,
        "douyin" to R.drawable.douyin,
        "ulzzang" to R.drawable.ulzzang,
        "bayonetta" to R.drawable.bayonetta,
        "gyaru" to R.drawable.gyaru,
        "idol" to R.drawable.idol,
        "doll" to R.drawable.doll,
        "latte" to R.drawable.latte,
        "strawberry" to R.drawable.strawberry,
        "darkfeminim" to R.drawable.darkfeminim,
        "arabian" to R.drawable.arabian,
        "tomie" to R.drawable.tomie,
        "natural" to R.drawable.natural,
        "y2k" to R.drawable.y2k
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Result ⋆. \uD801\uDE5A ˚") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFC1D9),
                    titleContentColor = Color.Black
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Hi, $userName ✨",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFD63384)
            )

            Text(
                text = if (recommendedStyles.isNotEmpty())
                    "Here are some makeup styles you can try!"
                else
                    "Oops, no styles found 🥺",
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(top = 4.dp, bottom = 24.dp)
            )

            recommendedStyles.forEach { style ->
                val imageResId = remember(style.styleCode) {
                    styleMap[style.styleCode] ?: R.drawable.empty_image
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFCE4EC)),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = imageResId),
                            contentDescription = style.imageName,
                            modifier = Modifier
                                .size(180.dp)
                                .padding(bottom = 12.dp)
                        )

                        Text(
                            text = "${style.imageName} Makeup",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF880E4F)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
