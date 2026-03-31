package com.example.audiolingo.ai

import org.json.JSONObject
import java.io.File

class Tokenizer(path: String) {

    private val vocab: Map<String, Int>

    init {
        val json = JSONObject(File(path).readText())
        vocab = json.keys().asSequence().associateWith { json.getInt(it) }
    }

    fun encode(text: String): IntArray {
        return text.split(" ").map { vocab[it] ?: 0 }.toIntArray()
    }
}