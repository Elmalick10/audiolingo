package com.example.audiolingo.pipeline

import com.example.audiolingo.api.ApiClient
import com.example.audiolingo.network.AudioUploader
import com.example.audiolingo.tts.TTSManager
import com.example.audiolingo.user.UserManager
import java.io.File

class AudioPipeline {

    suspend fun processText(text: String): String {
        val response = ApiClient.service.processText(
            mapOf("text" to text)
        )
        return response.body()?.get("output").toString()
    }

    suspend fun processAudio(file: File): String {

        return if (UserManager.isPremium()) {
            // 🌐 BACKEND PREMIUM
            AudioUploader.sendAudio(file, "fr")
        } else {
            // 📱 LOCAL STT (déjà chez toi)
            "LOCAL_PROCESSING_RESULT"
        }
    }

    suspend fun runPipeline(file: File, tts: TTSManager) {

        val result = processAudio(file)

        // 🔊 TTS
        tts.speak(result)
    }
}