package com.irv205.testproject.login.view

import com.irv205.testproject.model.User

interface LoginView {
    fun success(message:String)
    fun error(message:String)

    //TODO create a new FormView
    fun showUsers(users: List<User>)
    fun showError(message: String)

}