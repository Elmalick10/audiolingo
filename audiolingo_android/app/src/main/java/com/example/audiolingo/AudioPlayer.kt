package com.example.audiolingo

import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack

class AudioPlayer {

    private val sampleRate = 16000

    fun playAudio(audioData: ShortArray) {

        val audioTrack = AudioTrack(
            AudioManager.STREAM_MUSIC,
            sampleRate,
            AudioFormat.CHANNEL_OUT_MONO,
            AudioFormat.ENCODING_PCM_16BIT,
            audioData.size * 2,
            AudioTrack.MODE_STREAM
        )

        audioTrack.play()
        audioTrack.write(audioData, 0, audioData.size)
        audioTrack.stop()
        audioTrack.release()
    }
}