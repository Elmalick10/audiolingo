package com.example.audiolingo.ui
import android.view.View
import android.widget.HorizontalScrollView
import android.content.Context
import android.util.AttributeSet
import android.view.*
import android.widget.LinearLayout

class TimelineView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : HorizontalScrollView(context, attrs) {

    private val container = LinearLayout(context)

    init {
        container.orientation = LinearLayout.HORIZONTAL
        addView(container)
    }

    fun addClip(view: View) {

        view.setOnTouchListener(object : OnTouchListener {

            private var dX = 0f

            override fun onTouch(v: View, event: MotionEvent): Boolean {
                when (event.action) {

                    MotionEvent.ACTION_DOWN -> {
                        dX = v.x - event.rawX
                    }

                    MotionEvent.ACTION_MOVE -> {
                        v.x = event.rawX + dX
                    }
                }
                return true
            }
        })

        container.addView(view)
    }
}