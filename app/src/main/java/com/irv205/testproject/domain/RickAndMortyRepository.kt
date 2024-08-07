package com.irv205.testproject.domain

interface RickAndMortyRepository {
    suspend fun getCharacter(): List<Character>
}