package com.example.hekd.kotlinapp.ui.view7.practice01

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice01ArgbEvaluatorView : View {

    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    internal var color = -0x10000

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun getColor(): Int {
        return color
    }

    fun setColor(color: Int) {
        this.color = color
        invalidate()
    }

    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = width
        val height = height

        paint.color = color
        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), (width / 6).toFloat(), paint)
    }
}
