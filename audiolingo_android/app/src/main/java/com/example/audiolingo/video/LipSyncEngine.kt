package com.example.audiolingo.video

import android.util.Log
import java.io.File

class LipSyncEngine {

    fun extractPhonemes(audio: File): List<String> {

        Log.d("LipSync", "Analyse audio")

        // 🔥 Version simple (simulation)
        return listOf("A", "E", "O", "M", "F")

        // 👉 Plus tard :
        // - intégrer Whisper timestamps
        // - ou modèle phoneme (wav2vec / vosk)
    }
}