package com.irv205.testproject.data.service

import com.irv205.testproject.data.model.RickAndMortyResponse
import retrofit2.http.GET


interface RickAndMortyService {
    @GET("character/?page=19")
    suspend fun getCharacter(): RickAndMortyResponse
}