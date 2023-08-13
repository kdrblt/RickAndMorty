package com.example.rickandmorty.ui.characters

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items

@Composable
fun CharactersScreen(
    viewModel: CharactersViewModel = hiltViewModel(),
    navigateToDetail: (String) -> Unit,
) {
    val state = viewModel.state.value
    val characters = state.pagingData.collectAsLazyPagingItems()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Black),
    ) {
        LazyColumn {
            items(items = characters) { character ->
                character?.let {
                    CharacterItem(character = character) {
                        navigateToDetail(it.id.toString())
                    }
                }
            }
        }
    }
}
