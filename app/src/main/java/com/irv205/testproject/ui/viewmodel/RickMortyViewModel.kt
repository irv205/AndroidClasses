package com.irv205.testproject.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irv205.testproject.domain.Character
import com.irv205.testproject.domain.RickAndMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RickMortyViewModel @Inject constructor(private val rickAndMortyRepository: RickAndMortyRepository) :
    ViewModel() {

    private val _characters = MutableLiveData<List<Character>>()
    val character: LiveData<List<Character>> = _characters


    fun fetchCharacters() {
        viewModelScope.launch {
            val characters = rickAndMortyRepository.getCharacter()
            _characters.value = characters
        }

    }

}