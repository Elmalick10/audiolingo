package com.example.audiolingo

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.*

object TextToSpeechManager {

    private var tts: TextToSpeech? = null

    fun init(context: Context) {
        tts = TextToSpeech(context) {
            tts?.language = Locale.FRENCH
        }
    }

    fun speak(text: String) {
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }
}