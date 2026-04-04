package com.example.audiolingo.monetization

class RevenueManager {

    fun calculateRevenue(users: Int, price: Double): Double {
        return users * price
    }
}