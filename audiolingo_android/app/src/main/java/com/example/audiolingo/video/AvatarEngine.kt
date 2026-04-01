package com.example.audiolingo.video

import android.util.Log
import java.io.File

class AvatarEngine {

    private val faceAnimator = FaceAnimator()
    private val lipSync = LipSyncEngine()

    fun generateAvatarVideo(
        image: File,
        audio: File,
        output: File
    ) {

        Log.d("Avatar", "Début génération")

        // 1. Lip sync
        val phonemes = lipSync.extractPhonemes(audio)

        // 2. Animation visage
        faceAnimator.animateFace(image, phonemes, output)

        Log.d("Avatar", "Vidéo générée: ${output.path}")
    }
}