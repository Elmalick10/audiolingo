package com.example.audiolingo.video

import android.media.*
import java.io.File

class VideoExporter {

    fun export(subtitles: List<String>, output: String) {

        val file = File(output)

        val text = subtitles.joinToString("\n")

        file.writeText(text)

        // Ensuite → FFmpeg (à intégrer)
    }
}