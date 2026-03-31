package com.example.audiolingo.audio

import java.io.File
import java.io.FileOutputStream

class AudioExporter {

    fun saveWav(file: File, audio: ShortArray) {

        val fos = FileOutputStream(file)

        for (sample in audio) {
            fos.write(sample.toInt())
        }

        fos.close()
    }
}