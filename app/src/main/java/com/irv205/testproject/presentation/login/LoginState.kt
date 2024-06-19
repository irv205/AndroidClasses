package com.irv205.testproject.presentation.login

sealed class LoginState {
    object Default : LoginState()
    object Login: LoginState()
    object Register: LoginState()
    object Error: LoginState()

    object MailError: LoginState()
    object PasswordError: LoginState()
}