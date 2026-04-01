package com.example.audiolingo.core

object AIStubs {

    fun transcribe(audio: ByteArray): String {
        return "stub transcription"
    }

    fun translate(text: String): String {
        return "stub translation: $text"
    }

    fun synthesize(text: String): ByteArray {
        return ByteArray(0)
    }
}