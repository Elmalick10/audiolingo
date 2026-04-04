package com.example.audiolingo.network

import okhttp3.*

class NetworkManager {

    private val client = OkHttpClient()

    fun sendAudioToServer(audioData: ByteArray) {
        val requestBody = RequestBody.create(null, audioData)

        val request = Request.Builder()
            .url("https://your-api.com/process")
            .post(requestBody)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: java.io.IOException) {
                println("Error: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                println("Response: ${response.body?.string()}")
            }
        })
    }
}