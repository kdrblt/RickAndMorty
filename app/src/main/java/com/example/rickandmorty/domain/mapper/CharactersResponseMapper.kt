package com.example.rickandmorty.domain.mapper

import com.example.rickandmorty.data.model.response.CharacterModel
import com.example.rickandmorty.domain.dto.CharacterModelDto

fun CharacterModel.toDomainModel() = CharacterModelDto(
    id,
    name,
    image,
)

// for list
fun List<CharacterModel>?.toDomainModel() =
    this?.map { it.toDomainModel() } ?: arrayListOf()
