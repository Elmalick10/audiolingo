package com.example.audiolingo.ai.voice

import ai.onnxruntime.*

class XTTSManager(modelPath: String) {

    private val env = OrtEnvironment.getEnvironment()
    private val session = env.createSession(modelPath)

    fun generate(text: String, speaker: FloatArray): FloatArray {

        val textTensor = OnnxTensor.createTensor(env, arrayOf(text.length))
        val speakerTensor = OnnxTensor.createTensor(env, arrayOf(speaker))

        val result = session.run(
            mapOf(
                "text" to textTensor,
                "speaker" to speakerTensor
            )
        )

        return result[0].value as FloatArray
    }
}