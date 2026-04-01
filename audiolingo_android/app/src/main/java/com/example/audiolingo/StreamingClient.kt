package com.example.audiolingo

import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean

class StreamingClient {

    private val sampleRate = 16000
    private val bufferSize = AudioRecord.getMinBufferSize(
        sampleRate,
        AudioFormat.CHANNEL_IN_MONO,
        AudioFormat.ENCODING_PCM_16BIT
    )

    private var audioRecord: AudioRecord? = null
    private val isStreaming = AtomicBoolean(false)

    private val executor = Executors.newSingleThreadExecutor()

    fun startStreaming(onAudioChunk: (ByteArray) -> Unit) {

        if (isStreaming.get()) return

        audioRecord = AudioRecord(
            MediaRecorder.AudioSource.MIC,
            sampleRate,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT,
            bufferSize
        )

        audioRecord?.startRecording()
        isStreaming.set(true)

        executor.execute {

            val buffer = ByteArray(bufferSize)

            while (isStreaming.get()) {
                val read = audioRecord?.read(buffer, 0, buffer.size) ?: 0

                if (read > 0) {
                    val chunk = buffer.copyOf(read)

                    // 🔥 envoyer chunk audio
                    onAudioChunk(chunk)
                }
            }
        }
    }

    fun stopStreaming() {
        isStreaming.set(false)
        audioRecord?.stop()
        audioRecord?.release()
        audioRecord = null
    }

    fun sendAudioToServer(audioData: ByteArray) {
    // envoyer vers backend streaming
    }
}