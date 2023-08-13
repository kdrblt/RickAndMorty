package com.example.rickandmorty.domain.usecase

import androidx.paging.PagingData
import com.example.rickandmorty.domain.dto.CharacterModelDto
import com.example.rickandmorty.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharacterListUseCase @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository,
) {
    suspend operator fun invoke(): Flow<PagingData<CharacterModelDto>> =
        rickAndMortyRepository.getCharacters()
}
