package com.example.audiolingo.ai

class WhisperManager {

    fun transcribe(audio: ByteArray): String {
        println("🧠 STT via ONNX/NCNN")
        return "texte reconnu"
    }
}