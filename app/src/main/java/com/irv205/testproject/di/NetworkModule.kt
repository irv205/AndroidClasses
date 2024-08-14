package com.irv205.testproject.di

import com.irv205.testproject.data.service.RickAndMortyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideRickMortyService(retrofit: Retrofit): RickAndMortyService =
        retrofit.create(RickAndMortyService::class.java)


}