package com.example.rickandmorty.ui.characterdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.rickandmorty.ui.theme.Black
import com.example.rickandmorty.ui.theme.PrimaryBlue

@Composable
fun CharacterDetailScreen(
    viewModel: CharacterDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Black),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentAlignment = Alignment.Center,
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize(),
                model = state.character?.image,
                contentScale = ContentScale.FillBounds,
                contentDescription = null,
            )
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 8.dp,
                ),
            text = state.character?.name.toString(),
            color = PrimaryBlue,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
        )

        if (state.isLoading) {
            CircularProgressIndicator(color = PrimaryBlue)
        }

        if (state.error.isNotEmpty()) {
            Text(
                text = state.error,
                color = PrimaryBlue,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
            )
        }
    }
}
