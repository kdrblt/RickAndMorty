package com.example.rickandmorty.common

sealed class Resource<out T : Any> {
    data class OnSuccess<out T : Any>(val data: T) : Resource<T>()
    data class OnError<out T : Any>(val error: Throwable) : Resource<T>()
    object OnLoading : Resource<Nothing>()
}
