package com.example.rickandmorty.domain.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterModelDto(
    val id: Int?,
    val name: String?,
    val image: String?,
) : Parcelable
