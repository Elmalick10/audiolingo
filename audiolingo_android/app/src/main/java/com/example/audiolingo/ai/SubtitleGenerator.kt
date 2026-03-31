package com.example.audiolingo.ai

data class Subtitle(
    val text: String,
    val start: Long,
    val end: Long
)

class SubtitleGenerator {

    private var currentStart = System.currentTimeMillis()

    fun addText(text: String): Subtitle {

        val now = System.currentTimeMillis()

        val sub = Subtitle(
            text = text,
            start = currentStart,
            end = now
        )

        currentStart = now

        return sub
    }
}