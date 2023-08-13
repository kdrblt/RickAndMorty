package com.example.rickandmorty.domain.repository

import androidx.paging.PagingData
import com.example.rickandmorty.data.model.response.CharacterModel
import com.example.rickandmorty.domain.dto.CharacterModelDto
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    suspend fun getCharacters(): Flow<PagingData<CharacterModelDto>>
    suspend fun getUniqueCharacter(id: String): CharacterModel
}
