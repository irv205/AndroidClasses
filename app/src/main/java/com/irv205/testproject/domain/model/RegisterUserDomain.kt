package com.irv205.testproject.domain.model

data class RegisterUserDomain(
    val name: String,
    val lastname: String,
    val email: String,
    val password: String
)