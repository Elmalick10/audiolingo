package com.example.audiolingo.ai

class WhisperStreaming {

    private val buffer = mutableListOf<Float>()

    fun processChunk(audio: ShortArray): String {

        // 🔥 convert PCM → float
        val floatAudio = audio.map { it / 32768f }
        buffer.addAll(floatAudio)

        // 🔥 déclenche tous les X samples
        if (buffer.size > 16000) {

            val result = runWhisper(buffer.toFloatArray())
            buffer.clear()

            return result
        }

        return ""
    }

    private fun runWhisper(audio: FloatArray): String {

        // 🔥 ICI tu branches ONNX / NCNN
        // (placeholder pour l'instant)

        return "transcription partielle..."
    }
}