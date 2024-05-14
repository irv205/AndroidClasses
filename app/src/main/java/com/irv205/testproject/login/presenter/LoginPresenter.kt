package com.irv205.testproject.login.presenter

import com.irv205.testproject.model.User

interface LoginPresenter{
    fun login(user:String,pass:String)
    //TODO Separar
    fun addUser(user: String, pass: String)
}
