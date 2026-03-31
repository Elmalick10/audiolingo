package com.audiolingo.tv

class AudioProcessor {
    fun processAudio(audio: FloatArray) {
        // Convertir FloatArray en ptr + longueur pour Rust
        // TODO: utiliser JNI pour appeler `processAudioJNI`
    }
}