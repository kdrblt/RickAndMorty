package com.example.rickandmorty.data.model.response

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("info")
    val info: Info? = null,
    @SerializedName("results")
    val results: List<CharacterModel>? = null,
) {
    data class Info(
        @SerializedName("count")
        val count: Int? = null,
        @SerializedName("pages")
        val pages: Int? = null,
        @SerializedName("next")
        val next: String? = null,
        @SerializedName("prev")
        val prev: String? = null,
    )
}
