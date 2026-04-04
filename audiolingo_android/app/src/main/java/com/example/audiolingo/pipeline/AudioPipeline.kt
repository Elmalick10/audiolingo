package com.example.audiolingo.pipeline

import com.example.audiolingo.ai.WhisperManager
import com.example.audiolingo.tts.TTSManager

class AudioPipeline {

    private val whisper = WhisperManager()
    private val tts = TTSManager()

    fun process(text: String) {
        val result = whisper.transcribe(text)
        tts.speak(result)
    }
}