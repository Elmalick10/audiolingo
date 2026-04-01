package com.example.audiolingo.ai

import android.util.Log
import okhttp3.*
import java.io.File
import java.io.IOException

class WhisperManager {

    private val client = OkHttpClient()

    // 👉 URL backend (à modifier)
    private val BASE_URL = "https://TON_BACKEND.onrender.com/transcribe"

    fun transcribeAudio(file: File, callback: (String?) -> Unit) {

        val requestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart(
                "file",
                file.name,
                RequestBody.create("audio/wav".toMediaTypeOrNull(), file)
            )
            .build()

        val request = Request.Builder()
            .url(BASE_URL)
            .post(requestBody)
            .build()

        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                Log.e("Whisper", "Erreur: ${e.message}")
                callback(null)
            }

            override fun onResponse(call: Call, response: Response) {
                val result = response.body?.string()
                Log.d("Whisper", "Résultat: $result")
                callback(result)
            }
        })
    }
}