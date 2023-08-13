package com.example.rickandmorty.ui.characters

import androidx.paging.PagingData
import com.example.rickandmorty.domain.dto.CharacterModelDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class CharactersState(
    var pagingData: Flow<PagingData<CharacterModelDto>> = emptyFlow()
)
