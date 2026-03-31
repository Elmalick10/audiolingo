package com.example.audiolingo.ui.timeline

data class Clip(

    val id: String,

    // 🎬 type de clip
    val type: ClipType,

    // ⏱️ timing
    var startTime: Long,
    var endTime: Long,

    // 📁 source
    val filePath: String,

    // 🔊 audio
    var volume: Float = 1.0f,

    // 🎥 vidéo
    var scale: Float = 1.0f,
    var positionX: Float = 0f,
    var positionY: Float = 0f,

    // 🎙️ texte / sous-titre
    var text: String? = null
)

enum class ClipType {
    VIDEO,
    AUDIO,
    TEXT,
    SUBTITLE
}
class TimelineController {

    private val clips = mutableListOf<Clip>()

    fun addClip(clip: Clip) {
        clips.add(clip)
    }

    fun moveClip(id: String, newStart: Long) {
        val clip = clips.find { it.id == id } ?: return
        val duration = clip.endTime - clip.startTime

        clip.startTime = newStart
        clip.endTime = newStart + duration
    }

    fun splitClip(id: String, splitTime: Long) {

        val clip = clips.find { it.id == id } ?: return

        if (splitTime <= clip.startTime || splitTime >= clip.endTime) return

        val newClip = clip.copy(
            id = System.currentTimeMillis().toString(),
            startTime = splitTime
        )

        clip.endTime = splitTime

        clips.add(newClip)
    }

    fun getAll(): List<Clip> = clips
}