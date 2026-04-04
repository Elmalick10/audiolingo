package com.example.audiolingo.auth

import android.content.Context

object AuthManager {

    private const val PREF = "auth"
    private const val KEY_TOKEN = "token"

    fun saveToken(context: Context, token: String) {
        context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
            .edit()
            .putString(KEY_TOKEN, token)
            .apply()
    }

    fun getToken(context: Context): String? {
        return context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
            .getString(KEY_TOKEN, null)
    }
}