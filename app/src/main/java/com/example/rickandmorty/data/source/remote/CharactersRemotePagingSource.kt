package com.example.rickandmorty.data.source.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmorty.data.api.RickAndMortyRemoteApi
import com.example.rickandmorty.domain.dto.CharacterModelDto
import com.example.rickandmorty.domain.mapper.toDomainModel
import javax.inject.Inject

class CharactersRemotePagingSource @Inject constructor(
    private val rickAndMortyRemoteApi: RickAndMortyRemoteApi,
) : PagingSource<Int, CharacterModelDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModelDto> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = rickAndMortyRemoteApi.getCharacters(page = page)
            LoadResult.Page(
                data = response.results.toDomainModel(),
                prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                nextKey = if (response.info?.next.isNullOrEmpty()) null else page.plus(1),
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterModelDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }
}
