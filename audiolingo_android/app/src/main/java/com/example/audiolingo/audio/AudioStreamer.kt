package com.example.audiolingo.audio

import android.media.*
import kotlinx.coroutines.*
import java.util.concurrent.LinkedBlockingQueue

class AudioStreamer {

    private val sampleRate = 16000
    private val bufferSize = AudioRecord.getMinBufferSize(
        sampleRate,
        AudioFormat.CHANNEL_IN_MONO,
        AudioFormat.ENCODING_PCM_16BIT
    )

    private val queue = LinkedBlockingQueue<ShortArray>()
    private var isRunning = false

    fun startStreaming(onChunk: (ShortArray) -> Unit) {
        val recorder = AudioRecord(
            MediaRecorder.AudioSource.MIC,
            sampleRate,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT,
            bufferSize
        )

        isRunning = true
        recorder.startRecording()

        CoroutineScope(Dispatchers.IO).launch {
            while (isRunning) {
                val buffer = ShortArray(bufferSize / 2)
                recorder.read(buffer, 0, buffer.size)
                queue.put(buffer)
                onChunk(buffer)
            }
        }
    }

    fun stop() {
        isRunning = false
    }
}