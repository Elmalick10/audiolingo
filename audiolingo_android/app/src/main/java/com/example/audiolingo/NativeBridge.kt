package com.example.audiolingo

object NativeBridge {
    init {
        System.loadLibrary("audiolingo_core")
    }

    external fun processAudio(audioData: ByteArray): String
}