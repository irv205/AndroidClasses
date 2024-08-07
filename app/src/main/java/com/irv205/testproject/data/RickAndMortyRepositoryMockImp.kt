package com.irv205.testproject.data

import com.irv205.testproject.domain.Character
import com.irv205.testproject.domain.RickAndMortyRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class RickAndMortyRepositoryMockImp @Inject constructor(): RickAndMortyRepository {
    override suspend fun getCharacter(): List<Character> {
        delay(2000)
        return  listOf(Character("Rick Sanchez","Alive","https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
            Character("Morty Smith","Alive","https://rickandmortyapi.com/api/character/avatar/2.jpeg"),
            Character("Rick Sanchez","Alive","https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
            Character("Rick Sanchez","Alive","https://rickandmortyapi.com/api/character/avatar/1.jpeg"))
    }
}