package com.example.audiolingo.audio

class RNNoiseProcessor {

    init {
        try {
            System.loadLibrary("rnnoise")
        } catch (e: Exception) {
            println("RNNoise non chargé, fallback actif")
        }
    }

    // 🔥 appel natif (C++)
    external fun processFrame(input: FloatArray): FloatArray

    // 🎧 traitement audio complet (stream)
    fun process(audio: ShortArray): ShortArray {

        val floatInput = audio.map { it / 32768f }.toFloatArray()

        val cleaned = try {
            processFrame(floatInput)
        } catch (e: Exception) {
            // 🔥 fallback simple si RNNoise absent
            simpleDenoise(floatInput)
        }

        return cleaned.map {
            (it * 32768f).toInt().coerceIn(-32768, 32767).toShort()
        }.toShortArray()
    }

    // ⚡ fallback léger (filtre basique)
    private fun simpleDenoise(input: FloatArray): FloatArray {

        val output = FloatArray(input.size)

        for (i in input.indices) {
            val prev = if (i > 0) input[i - 1] else input[i]
            val next = if (i < input.size - 1) input[i + 1] else input[i]

            // 🔥 filtre moyenne simple
            output[i] = (prev + input[i] + next) / 3f
        }

        return output
    }
}