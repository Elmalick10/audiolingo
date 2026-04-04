package com.example.audiolingo.user

object PremiumManager {
    private var isPremium = false

    fun setPremium(value: Boolean) {
        isPremium = value
    }

    fun isPremium(): Boolean {
        return isPremium
    }
}