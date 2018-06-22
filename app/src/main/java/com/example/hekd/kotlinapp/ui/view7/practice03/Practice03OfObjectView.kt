package com.example.hekd.kotlinapp.ui.view7.practice03

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View

import com.example.hekd.kotlinapp.Utils


class Practice03OfObjectView : View {

    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    internal var position = PointF()

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        paint.color = Color.parseColor("#009688")
    }

    fun getPosition(): PointF = position

    fun setPosition(position: PointF) {
        this.position.set(position)
        invalidate()
    }

    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val innerPaddingLeft = RADIUS * 1
        val innerPaddingRight = RADIUS * 1
        val innerPaddingTop = RADIUS * 1
        val innerPaddingBottom = RADIUS * 3

        val width = width.toFloat() - innerPaddingLeft - innerPaddingRight - RADIUS * 2
        val height = height.toFloat() - innerPaddingTop - innerPaddingBottom - RADIUS * 2

        canvas.drawCircle(innerPaddingLeft + RADIUS + width * position.x, innerPaddingTop + RADIUS + height * position.y, RADIUS, paint)
    }

    companion object {
        val RADIUS = Utils.dpToPixel(20f)
    }
}
