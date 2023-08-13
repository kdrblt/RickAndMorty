package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.common.Resource
import com.example.rickandmorty.domain.dto.CharacterModelDto
import com.example.rickandmorty.domain.mapper.toDomainModel
import com.example.rickandmorty.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUniqueCharacterUseCase @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository,
) {
    data class Params(
        val id: String,
    )

    operator fun invoke(parameters: Params): Flow<Resource<CharacterModelDto>> = flow {
        try {
            emit(Resource.OnLoading)
            emit(
                Resource.OnSuccess(
                    rickAndMortyRepository.getUniqueCharacter(parameters.id).toDomainModel(),
                ),
            )
        } catch (e: Exception) {
            emit(Resource.OnError(e))
        }
    }
}
