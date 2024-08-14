package com.irv205.testproject.data.repository

import com.irv205.testproject.data.mapper.toCharacters
import com.irv205.testproject.data.service.RickAndMortyService
import com.irv205.testproject.domain.Character
import com.irv205.testproject.domain.RickAndMortyRepository
import javax.inject.Inject

class RickAndMortyRepositoryImp @Inject constructor(private val service: RickAndMortyService) :
    RickAndMortyRepository {
    override suspend fun getCharacter(): List<Character> {
        return service.getCharacter().toCharacters()
    }
}