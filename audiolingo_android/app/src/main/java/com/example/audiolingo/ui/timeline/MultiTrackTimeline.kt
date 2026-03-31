package com.example.audiolingo.ui.timeline

import android.content.Context
import android.widget.LinearLayout

class MultiTrackTimeline(context: Context) : LinearLayout(context) {

    private val tracks = mutableListOf<TrackView>()

    init {
        orientation = VERTICAL
    }

    fun addTrack(): TrackView {
        val track = TrackView(context)
        tracks.add(track)
        addView(track)
        return track
    }
}