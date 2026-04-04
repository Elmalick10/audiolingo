package com.example.audiolingo

class STTManager {
    fun transcribe(audio: ByteArray): String {
        return "test transcription"

        val text = whisperResult

        val processed = sendToBackend(text)

        tts.speak(processed)
    }
}