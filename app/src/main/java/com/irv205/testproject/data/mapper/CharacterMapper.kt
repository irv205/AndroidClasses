package com.irv205.testproject.data.mapper

import com.irv205.testproject.data.model.Result
import com.irv205.testproject.data.model.RickAndMortyResponse
import com.irv205.testproject.domain.Character


fun RickAndMortyResponse.toCharacters(): List<Character> {
    return this.results.map { result -> result.toCharacter() }
}


fun Result.toCharacter(): Character {
    return Character(this.name, this.status, this.image)
}