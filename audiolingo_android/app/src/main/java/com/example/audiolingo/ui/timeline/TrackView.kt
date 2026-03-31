package com.example.audiolingo.ui.timeline

import android.content.Context
import android.view.View
import android.widget.LinearLayout

class TrackView(context: Context) : LinearLayout(context) {

    init {
        orientation = HORIZONTAL
    }

    fun addClipView(view: View) {
        addView(view)
    }
}