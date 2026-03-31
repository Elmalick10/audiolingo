package com.example.audiolingo.billing

class BillingManager {

    fun isPremium(userId: String): Boolean {
        return false
    }

    fun unlockPremium() {
        // Appel API serveur (Stripe / PayPal)
    }
}