package com.irv205.testproject.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irv205.testproject.domain.model.Character
import com.irv205.testproject.domain.model.Song

class LoginViewModel : ViewModel() {

    private val _user = MutableLiveData<Boolean>()
    val user : LiveData<Boolean> get() = _user

    private val _login = MutableLiveData<Boolean>()
    val login : LiveData<Boolean> get() = _login

    private val _register = MutableLiveData<Boolean>()
    val register : LiveData<Boolean> get() = _register


    fun validateUser(mail: String) {

        if (mail == "Irving") _user.value = true
        else _user.value = false

    }

}