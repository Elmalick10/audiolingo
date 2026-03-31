package com.example.audiolingo.pipeline

data class Subtitle(
    val text: String,
    val start: Long,
    val end: Long
)

class SubtitleGenerator {

    private var currentTime = 0L

    fun generate(text: String): Subtitle {

        val duration = text.length * 50L

        val subtitle = Subtitle(
            text,
            currentTime,
            currentTime + duration
        )

        currentTime += duration
        return subtitle
    }
}