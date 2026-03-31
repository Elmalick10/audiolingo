package com.example.audiolingo.pipeline

import com.example.audiolingo.ai.*
import com.example.audiolingo.audio.*

class AudioPipeline(
    whisper: WhisperONNX,
    translator: TranslatorONNX,
    tokenizer: Tokenizer
) {

    private val streamer = AudioStreamer()
    private val subtitleGen = SubtitleGenerator()

    fun start() {

        streamer.startStreaming { chunk ->

            val floatAudio = chunk.map { it / 32768f }.toFloatArray()

            val text = whisper.transcribe(floatAudio)

            val tokens = tokenizer.encode(text)

            val translated = translator.translate(tokens)

            val subtitle = subtitleGen.generate(translated)

            val rnnoise = RNNoiseProcessor()

            val cleanAudio = rnnoise.process(rawAudio)

            println("🎬 SUBTITLE: $subtitle")

            val frameSize = 480
        }
    }
}