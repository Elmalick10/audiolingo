package com.example.audiolingo.ai

class Summarizer {

    fun summarize(text: String): String {

        return if (text.length > 200) {
            text.substring(0, 200) + "..."
        } else text
    }
}