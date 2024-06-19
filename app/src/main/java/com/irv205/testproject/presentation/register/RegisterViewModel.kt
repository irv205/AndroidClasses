package com.irv205.testproject.presentation.register

import androidx.lifecycle.ViewModel
import com.irv205.testproject.domain.model.RegisterUserDomain

class RegisterViewModel: ViewModel() {

    fun validateRegistro(registerUserDomain: RegisterUserDomain) {
        when{
            registerUserDomain.name.isEmpty() -> {

            }
        }
    }

    fun registro(){

    }
}