package com.example.rickandmorty.ui.characterdetail

import com.example.rickandmorty.domain.dto.CharacterModelDto

data class CharacterDetailState(
    val isLoading: Boolean = false,
    val character: CharacterModelDto? = null,
    val error: String = "",
)
