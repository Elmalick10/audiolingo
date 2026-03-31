package com.example.audiolingo.ai

class XTTS_ONNX {

    fun generate(text: String): FloatArray {

        // 🔥 modèle XTTS ONNX ici (placeholder)

        val length = 16000
        val audio = FloatArray(length)

        for (i in audio.indices) {
            audio[i] = kotlin.math.sin(i * 0.01).toFloat()
        }

        return audio
    }
}