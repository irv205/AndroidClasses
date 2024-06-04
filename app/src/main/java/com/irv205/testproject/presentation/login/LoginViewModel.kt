package com.irv205.testproject.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irv205.testproject.domain.model.Character
import com.irv205.testproject.domain.model.Song

class LoginViewModel : ViewModel() {

    private val _character = MutableLiveData<Character>()
    val character : LiveData<Character> get() = _character

    init {
        createCharacter()
    }

    private fun createCharacter(){
        _character.value = Character(
            1,
            "Rick",
            "Vivo",
            "Humano"
        )
    }

}