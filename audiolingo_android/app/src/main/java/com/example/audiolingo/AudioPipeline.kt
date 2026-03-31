package com.example.audiolingo

object AudioPipeline {

    fun processStream(audioChunk: ByteArray) {

        val clean = RNNoiseProcessor.process(audioChunk)

        val text = STTManager.transcribe(clean)

        if (text.isNotEmpty()) {

            val translated = Translator.translate(text)

            TTSManager.speak(translated)

            val subtitles = SubtitleGenerator.generate(
                listOf(Pair(text, System.currentTimeMillis()))
            )

            ExportManager.exportSrt(subtitles)
        }
        class AudioPipeline {

    fun process(audio: ByteArray): String {
        return "pipeline ok"
            }
        }
    }
}