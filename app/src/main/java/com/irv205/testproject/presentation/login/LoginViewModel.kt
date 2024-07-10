package com.irv205.testproject.presentation.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irv205.testproject.domain.model.RegisterUserDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {

    private val _loginState = MutableLiveData<LoginState>()
    val loginState: LiveData<LoginState> get() = _loginState
    var job: Job? = null

    //DB
    fun validateLogin(mail: String, password: String) {

        if (mail == "Irving" && password == "1234") _loginState.value = LoginState.Login
        else if (mail != "Irving") _loginState.value = LoginState.MailError
        else if (password != "1234") _loginState.value = LoginState.PasswordError
        else _loginState.value = LoginState.Error
        // Pinar Algo

    }

    fun cancelCoroutine() {
        job?.cancel()
    }

    fun testCoroutine() {
        var result: String = ""
        callThread()
        job = viewModelScope.launch() {
            // val initilized =
            //LLamada API

            result = withContext(Dispatchers.IO) { callService() }
            result = withContext(Dispatchers.IO) { callService2() }
            //result = (deferred1.await() +" "+ deferred2.await())
            //Pintar Respuesta
            Log.e("Result", result)
        }

    }

    fun asyncTest() {
        var result: String = ""
        job = viewModelScope.launch {
            val deferred1 = async {
                callService()
            }

            val deferred2 = async {
                callService2()
            }
            result = (deferred1.await() +" "+ deferred2.await())
        }

    }

//NOOOOOOOOOOO solo ejemplo
    fun callThread(){
        var counter = 0
        Thread().run{
            while (counter < 11) {
                Thread.sleep(1000)
                Log.e("Service 1", (counter++).toString())
            }
        }
    }

    suspend fun callService(): String {
        var counter = 0
        while (counter < 11) {
            delay(1000)
            Log.e("Service 1", (counter++).toString())
        }
        return "Success API 1"
    }

    suspend fun callService2(): String {
        var counter = 0
        while (counter < 11) {
            delay(1000)
            Log.e("Service 2", (counter++).toString())
        }
        return "Success Api 2"
    }

}


object DummyDB {
    private val users: MutableList<User> = mutableListOf()

    suspend fun addUser(user: User) {
        delay(2000)
        users.add(user)
    }

    suspend fun getUser(username: String): User? {
        delay(2000)
        return users.find { it.userName == username }
    }

    suspend fun getAllUsers(): List<User> {
        delay(2000)
        return users
    }
}

data class User(
    val userName: String
)