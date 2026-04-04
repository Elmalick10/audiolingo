package com.example.audiolingo.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val auth = AuthManager(this)
        auth.saveToken("demo_token")
    }
}