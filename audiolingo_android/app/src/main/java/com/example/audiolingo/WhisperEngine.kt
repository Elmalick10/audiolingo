package com.example.audiolingo

class WhisperEngine {

    external fun initModel(path: String)

    external fun transcribe(audio: FloatArray): String

    companion object {
        init {
            System.loadLibrary("whisper")
        }
    }

}