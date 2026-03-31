package com.example.audiolingo.ui.timeline

class TimelineController {

    val clips = mutableListOf<Clip>()

    fun splitClip(id: String, splitTime: Long) {

        val clip = clips.find { it.id == id } ?: return

        val newClip = clip.copy(
            id = id + "_2",
            start = splitTime,
            duration = clip.duration - splitTime
        )

        clip.duration = splitTime
        clips.add(newClip)
    }
}