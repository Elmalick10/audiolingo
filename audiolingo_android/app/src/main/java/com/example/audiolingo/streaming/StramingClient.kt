package com.example.audiolingo.streaming

import android.util.Log
import okhttp3.*
import java.io.IOException
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody

class StreamingClient {

    private val client = OkHttpClient()

    private val STREAM_URL = "https://TON_BACKEND.onrender.com/stream"

    fun sendAudioChunk(data: ByteArray) {

        val body = RequestBody.create("application/octet-stream".toMediaTypeOrNull(), data)

        val request = Request.Builder()
            .url(STREAM_URL)
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {
                Log.e("Streaming", "Erreur: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d("Streaming", "Chunk envoyé")
            }
        })
    }
}