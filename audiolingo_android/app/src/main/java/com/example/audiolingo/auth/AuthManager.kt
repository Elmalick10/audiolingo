package com.example.audiolingo.auth

import android.content.Context

class AuthManager(private val context: Context) {

    fun isLoggedIn(): Boolean {
        val prefs = context.getSharedPreferences("user", Context.MODE_PRIVATE)
        return prefs.getString("token", null) != null
    }

    fun saveToken(token: String) {
        val prefs = context.getSharedPreferences("user", Context.MODE_PRIVATE)
        prefs.edit().putString("token", token).apply()
    }

    fun getToken(): String? {
        val prefs = context.getSharedPreferences("user", Context.MODE_PRIVATE)
        return prefs.getString("token", null)
    }
}