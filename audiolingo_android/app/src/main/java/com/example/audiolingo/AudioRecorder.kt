package com.example.audiolingo

import android.media.*

class AudioRecorder {

    private var isRecording = false

    fun startStreaming(onAudio: (ByteArray) -> Unit) {

        val bufferSize = 2048
        val buffer = ByteArray(bufferSize)

        val recorder = AudioRecord(
            MediaRecorder.AudioSource.MIC,
            16000,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT,
            bufferSize
        )

        recorder.startRecording()
        isRecording = true

        Thread {
            while (isRecording) {

                val read = recorder.read(buffer, 0, bufferSize)

                if (read > 0) {
                    onAudio(buffer.copyOf())
                }
            }

            recorder.stop()
            recorder.release()
        }.start()
    }

    fun stop() {
        isRecording = false
    }
}