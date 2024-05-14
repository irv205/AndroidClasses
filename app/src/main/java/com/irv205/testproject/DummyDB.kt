package com.irv205.testproject

import com.irv205.testproject.model.User

object DummyDB {
    val users: MutableList<User> = mutableListOf()


    fun addUser(user: User) {
        users.add(user)
    }

    fun getUser(username: String): User? {
        return users.find { it.username == username }
    }

    fun getAllUsers(): List<User> {
        return users
    }
}