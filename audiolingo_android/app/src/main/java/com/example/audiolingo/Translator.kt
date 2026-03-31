package com.example.audiolingo

import ai.onnxruntime.*

object Translator {

    private var env: OrtEnvironment? = null
    private var session: OrtSession? = null

    fun init(context: android.content.Context) {
        env = OrtEnvironment.getEnvironment()

        val model = context.assets.open("models/translator.onnx").readBytes()
        session = env!!.createSession(model)
    }

    fun translate(text: String): String {
        // ⚠️ simplifié (tokenizer à ajouter plus tard)
        return "[Translated OFFLINE] $text"
    }
}