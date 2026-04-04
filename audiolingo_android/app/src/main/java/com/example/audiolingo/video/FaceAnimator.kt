package com.example.audiolingo.video

import android.graphics.Bitmap

class FaceAnimator {

    fun animateFace(audioPath: String, faceImage: Bitmap): Bitmap {
        // TODO: intégrer modèle IA (Wav2Lip / SadTalker)
        simulateBlink()
        simulateMicroExpressions()
        return faceImage
    }

    private fun simulateBlink() {
        println("👀 Clignement des yeux simulé")
    }

    private fun simulateMicroExpressions() {
        println("🧠 Micro-expressions simulées")
    }
}