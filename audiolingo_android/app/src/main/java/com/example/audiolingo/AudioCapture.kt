package com.example.audiolingo

import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder

class AudioCapture {

    private val sampleRate = 16000

    private val bufferSize = AudioRecord.getMinBufferSize(
        sampleRate,
        AudioFormat.CHANNEL_IN_MONO,
        AudioFormat.ENCODING_PCM_16BIT
    )

    private val audioRecord = AudioRecord(
        MediaRecorder.AudioSource.MIC,
        sampleRate,
        AudioFormat.CHANNEL_IN_MONO,
        AudioFormat.ENCODING_PCM_16BIT,
        bufferSize
    )

    fun startRecording() {
        audioRecord.startRecording()
    }

    fun read(buffer: ShortArray): Int {
        return audioRecord.read(buffer, 0, buffer.size)
    }

    fun stopRecording() {
        audioRecord.stop()
        audioRecord.release()
    }
}