package com.example.audiolingo.ai

class WhisperManager {

    fun transcribe(audio: ByteArray): String {
        println("🧠 STT via ONNX/NCNN")
        return "texte reconnu"
        val text = whisperResult

        val processed = sendToBackend(text)

        tts.speak(processed)
    }
}