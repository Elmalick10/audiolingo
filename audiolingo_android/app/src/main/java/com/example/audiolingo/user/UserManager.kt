package com.example.audiolingo.user

class UserManager {

    var isLoggedIn = false

    fun login(email: String, password: String): Boolean {
        if (email == "test@test.com" && password == "1234") {
            isLoggedIn = true
        }
        return isLoggedIn
    }
}