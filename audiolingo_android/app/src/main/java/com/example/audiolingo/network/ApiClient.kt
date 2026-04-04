package com.example.audiolingo.network

import okhttp3.*
import java.io.IOException

class ApiClient {

    private val client = OkHttpClient()
    private val BASE_URL = "https://audiolingo.onrender.com"

    fun login(email: String, password: String) {

        val request = Request.Builder()
            .url("$BASE_URL/auth/login?email=$email&password=$password")
            .post(RequestBody.create(null, ByteArray(0)))
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("❌ Erreur réseau")
            }

            override fun onResponse(call: Call, response: Response) {
                println("✅ Connecté au backend")
            }
        })
    }

    fun transcribeAudio(audio: ByteArray) {

        val request = Request.Builder()
            .url("$BASE_URL/ai/transcribe")
            .post(RequestBody.create(null, audio))
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("❌ Erreur STT")
            }

            override fun onResponse(call: Call, response: Response) {
                println("🧠 Transcription OK")
            }
        })
    }
}