package com.example.audiolingo.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class SubtitleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private var text: String = ""

    private val paint = Paint().apply {
        color = Color.WHITE
        textSize = 48f
        isAntiAlias = true
        textAlign = Paint.Align.CENTER
        typeface = Typeface.DEFAULT_BOLD
    }

    private val backgroundPaint = Paint().apply {
        color = Color.parseColor("#80000000") // fond noir transparent
    }

    fun setSubtitle(newText: String) {
        text = newText
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (text.isEmpty()) return

        val x = width / 2f
        val y = height - 150f

        val padding = 20f

        val textWidth = paint.measureText(text)
        val textHeight = paint.textSize

        val rect = RectF(
            x - textWidth / 2 - padding,
            y - textHeight - padding,
            x + textWidth / 2 + padding,
            y + padding
        )

        // 🎬 fond style CapCut
        canvas.drawRoundRect(rect, 20f, 20f, backgroundPaint)

        // 🎬 texte
        canvas.drawText(text, x, y, paint)
    }
}