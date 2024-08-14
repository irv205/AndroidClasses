package com.irv205.testproject.di

import com.irv205.testproject.data.repository.RickAndMortyRepositoryImp
import com.irv205.testproject.data.repository.RickAndMortyRepositoryMockImp
import com.irv205.testproject.domain.RickAndMortyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun binRickAndMortyRepository(rickAndMortyRepositoryImp: RickAndMortyRepositoryImp): RickAndMortyRepository

}