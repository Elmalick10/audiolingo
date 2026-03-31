package com.example.audiolingo.ai

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.*
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.atomic.AtomicBoolean

class TTSManager(context: Context) {

    private var tts: TextToSpeech? = null
    private val isReady = AtomicBoolean(false)

    // 🔥 file d’attente pour éviter coupures
    private val queue: Queue<String> = ConcurrentLinkedQueue()

    init {
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                isReady.set(true)
                tts?.language = Locale.US
                processQueue()
            }
        }
    }

    // 🎙️ parler (ajoute dans la queue)
    fun speak(text: String) {
        if (text.isBlank()) return
        queue.add(text)
        processQueue()
    }

    // 🔥 traitement file d’attente
    private fun processQueue() {
        if (!isReady.get()) return
        if (tts?.isSpeaking == true) return

        val text = queue.poll() ?: return

        tts?.speak(
            text,
            TextToSpeech.QUEUE_FLUSH,
            null,
            UUID.randomUUID().toString()
        )
    }

    // 🌍 changer langue dynamiquement
    fun setLanguage(locale: Locale) {
        tts?.language = locale
    }

    // 🔊 stop
    fun stop() {
        tts?.stop()
        queue.clear()
    }

    // ❌ release mémoire
    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
    }

    // 🚀 FUTUR (XTTS / ONNX)
    fun speakWithAI(text: String) {
        // 🔥 ici tu brancheras :
        // XTTS / ONNX / Voice Cloning
        println("AI Voice: $text")
    }
}