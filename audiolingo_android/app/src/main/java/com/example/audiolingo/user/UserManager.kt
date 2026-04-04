package com.example.audiolingo.user

import com.example.audiolingo.billing.BillingManager

object UserManager {

    fun isPremium(): Boolean {
        return BillingManager.isUserPremium()
        }
    }

class UserManager {

    var isLoggedIn = false

    fun login(email: String, password: String): Boolean {
        if (email == "test@test.com" && password == "1234") {
            isLoggedIn = true
        }
        return isLoggedIn
    }
}