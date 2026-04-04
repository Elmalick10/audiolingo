package com.example.audiolingo.security

class SecurityManager {

    fun detectFraud(userId: String): Boolean {
        println("🔍 Analyse comportement utilisateur")
        return false
    }

    fun blockUser(userId: String) {
        println("🚫 Utilisateur bloqué")
    }
}