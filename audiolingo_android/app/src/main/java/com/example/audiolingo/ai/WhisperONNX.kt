package com.example.audiolingo.ai

import ai.onnxruntime.*

class WhisperONNX(context: android.content.Context) {

    private val env = OrtEnvironment.getEnvironment()
    private val session: OrtSession

    init {
        val model = context.assets.open("whisper-tiny.onnx").readBytes()
        session = env.createSession(model)
    }

    fun transcribe(audio: FloatArray): String {

        val inputName = session.inputNames.iterator().next()

        val tensor = OnnxTensor.createTensor(
            env,
            arrayOf(audio)
        )

        val result = session.run(mapOf(inputName to tensor))

        return result[0].value.toString()
    }
}