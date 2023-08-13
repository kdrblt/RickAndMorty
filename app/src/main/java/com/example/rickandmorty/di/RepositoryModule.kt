package com.example.rickandmorty.di

import com.example.rickandmorty.data.api.RickAndMortyRemoteApi
import com.example.rickandmorty.data.repository.RickAndMortyRepositoryImpl
import com.example.rickandmorty.domain.repository.RickAndMortyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRickAndMortyRepository(
        rickAndMortyRemoteApi: RickAndMortyRemoteApi,
    ): RickAndMortyRepository {
        return RickAndMortyRepositoryImpl(rickAndMortyRemoteApi)
    }
}
