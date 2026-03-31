package com.example.audiolingo

import android.media.*
import android.media.projection.MediaProjection

class TVAudioCapture {

    private val sampleRate = 16000

    fun startCapture(onAudio: (ShortArray) -> Unit) {

        val bufferSize = AudioRecord.getMinBufferSize(
            sampleRate,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT
        )

        val recorder = AudioRecord(
            MediaRecorder.AudioSource.DEFAULT,
            sampleRate,
            AudioFormat.CHANNEL_IN_MONO,
            AudioFormat.ENCODING_PCM_16BIT,
            bufferSize
        )

        val buffer = ShortArray(bufferSize)

        recorder.startRecording()

        Thread {

            while (true) {

                val read = recorder.read(buffer,0,buffer.size)

                if(read>0){
                    onAudio(buffer)
                }

            }

        }.start()

    }

}