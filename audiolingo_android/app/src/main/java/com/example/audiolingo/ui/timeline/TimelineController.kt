package com.example.audiolingo.ui.timeline

class TimelineController {

    private val clips = mutableListOf<Clip>()

    fun addClip(clip: Clip) {
        clips.add(clip)
    }
}