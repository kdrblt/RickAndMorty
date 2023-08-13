package com.example.rickandmorty.data.api

import com.example.rickandmorty.data.model.response.CharacterModel
import com.example.rickandmorty.data.model.response.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyRemoteApi {

    @GET(CHARACTERS)
    suspend fun getCharacters(
        @Query("page") page: Int? = null,
    ): CharactersResponse

    @GET(CHARACTER)
    suspend fun getUniqueCharacter(
        @Path("id") id: String?,
    ): CharacterModel

    companion object {
        private const val CHARACTERS = "character"
        private const val CHARACTER = "character/{id}"
    }
}
