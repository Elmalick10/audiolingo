package com.example.audiolingo.billing

class SubscriptionManager {

    fun isPremium(userId: String): Boolean {
        // connecté API serveur
        return false
    }

    fun blockFreeUser() {
        println("🚫 Fonction bloquée pour utilisateur gratuit")
    }
}