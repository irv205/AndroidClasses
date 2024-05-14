package com.irv205.testproject.login.presenter

import com.irv205.testproject.DummyDB
import com.irv205.testproject.login.view.LoginView
import com.irv205.testproject.model.User

class LoginPresenterImp(private val loginView: LoginView): LoginPresenter {

    private val dummyDb = DummyDB

    override fun login(user: String, pass: String) {
        val currentUser = dummyDb.getUser(user)
        if (currentUser == null) loginView.error("Usuario no existe")
        currentUser?.let {
            if (it.password == pass){
                loginView.success("Login Success")
            } else {
                loginView.error("Contraseña no valida")
            }
        }
    }


    //TODO REMOVE , create new flow
    override fun addUser(user: String, pass: String) {
        if (user.isNotEmpty() && pass.isNotEmpty()){
            val user1 = User(user, pass)
            dummyDb.addUser(user1)
            loginView.showUsers(dummyDb.getAllUsers())
        }else{
            loginView.showError("Error en formulario")
        }
    }

}