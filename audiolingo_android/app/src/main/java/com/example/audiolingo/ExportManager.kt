package com.example.audiolingo

import java.io.File

object ExportManager {

    fun exportTxt(content: String) {
        File("/sdcard/audiolingo.txt").writeText(content)
    }

    fun exportSrt(content: String) {
        File("/sdcard/audiolingo.srt").writeText(content)
    }
}