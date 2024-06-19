package com.irv205.testproject.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irv205.testproject.domain.model.RegisterUserDomain

class LoginViewModel : ViewModel() {

    private val _loginState = MutableLiveData<LoginState>()
    val loginState : LiveData<LoginState> get() = _loginState

    //DB


    fun validateLogin(mail: String, password: String) {

        if (mail == "Irving" && password == "1234") _loginState.value = LoginState.Login
        else if (mail != "Irving") _loginState.value = LoginState.MailError
        else if (password != "1234") _loginState.value = LoginState.PasswordError
        else _loginState.value = LoginState.Error

    }

}