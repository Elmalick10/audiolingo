package com.example.audiolingo.ai

import ai.onnxruntime.*

class TranslatorONNX(modelPath: String) {

    private val env = OrtEnvironment.getEnvironment()
    private val session = env.createSession(modelPath)

    fun translate(tokens: IntArray): String {

        val tensor = OnnxTensor.createTensor(env, arrayOf(tokens))

        val result = session.run(mapOf("input_ids" to tensor))

        return result[0].value.toString()
    }
}