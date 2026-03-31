package com.example.audiolingo

object Summarizer {

    fun summarize(text: String): String {
        val sentences = text.split(".")
        return sentences.take(2).joinToString(".") + "."
    }
}