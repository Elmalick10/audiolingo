package com.example.audiolingo.audio

import android.media.*
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean

class AudioRecorder {

    private val sampleRate = 16000
    private val bufferSize = AudioRecord.getMinBufferSize(
        sampleRate,
        AudioFormat.CHANNEL_IN_MONO,
        AudioFormat.ENCODING_PCM_16BIT
    )

    private var recorder: AudioRecord? = null
    private val isRecording = AtomicBoolean(false)
    private val executor = Executors.newSingleThreadExecutor()

    fun start(onChunk: (ShortArray) -> Unit) {

        recorder = AudioRecord(
            MediaRecorder.AudioSource.MIC,
            sampleRate,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT,
            bufferSize
        )

        recorder?.startRecording()
        isRecording.set(true)

        executor.execute {
            val buffer = ShortArray(bufferSize)

            while (isRecording.get()) {
                val read = recorder?.read(buffer, 0, buffer.size) ?: 0
                if (read > 0) {
                    onChunk(buffer.copyOf(read))
                }
            }
        }
    }

    fun stop() {
        isRecording.set(false)
        recorder?.stop()
        recorder?.release()
        recorder = null
    }
}