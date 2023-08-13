package com.example.rickandmorty.ui.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.rickandmorty.domain.dto.CharacterModelDto
import com.example.rickandmorty.ui.theme.Black
import com.example.rickandmorty.ui.theme.Green
import com.example.rickandmorty.ui.theme.PrimaryBlue
import com.example.rickandmorty.ui.theme.White

@Composable
fun CharacterItem(
    character: CharacterModelDto,
    onClick: () -> Unit,
) {
    val configuration = LocalConfiguration.current
    val imageHeight = (configuration.screenHeightDp / 3f).dp

    Card(
        modifier = Modifier
            .height(imageHeight)
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        backgroundColor = Color.LightGray,

    ) {
        Box {
            AsyncImage(
                modifier = Modifier
                    .height(imageHeight)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp))
                    .align(Alignment.Center),
                model = character.image.toString(),
                contentDescription = null,
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = 8.dp,
                    )
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                PrimaryBlue,
                                Black,
                                Green,
                            ),
                        ),
                    ),
                text = character.name.toString(),
                color = White,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
            )
        }
    }
}
