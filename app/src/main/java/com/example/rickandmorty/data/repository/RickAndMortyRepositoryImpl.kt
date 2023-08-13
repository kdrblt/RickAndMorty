package com.example.rickandmorty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmorty.data.api.RickAndMortyRemoteApi
import com.example.rickandmorty.data.model.response.CharacterModel
import com.example.rickandmorty.data.source.remote.CharactersRemotePagingSource
import com.example.rickandmorty.domain.dto.CharacterModelDto
import com.example.rickandmorty.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(
    private val rickAndMortyRemoteApi: RickAndMortyRemoteApi,
) : RickAndMortyRepository {
    override suspend fun getCharacters(): Flow<PagingData<CharacterModelDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 2,
            ),
            pagingSourceFactory = {
                CharactersRemotePagingSource(rickAndMortyRemoteApi)
            },
        ).flow
    }
    // rickAndMortyRemoteApi.getCharacters()

    override suspend fun getUniqueCharacter(id: String): CharacterModel =
        rickAndMortyRemoteApi.getUniqueCharacter(id)
}
