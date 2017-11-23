package com.example.hekd.kotlinapp.ui.view2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice09StrokeCapView : View {
    internal val paint = Paint(Paint.ANTI_ALIAS_FLAG)


    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.strokeWidth=20f

        paint.strokeCap=Paint.Cap.BUTT
        canvas!!.drawLine(50f,50f,400f,50f,paint)
        paint.strokeCap=Paint.Cap.ROUND
        canvas.drawLine(50f,100f,400f,100f,paint)
        paint.strokeCap=Paint.Cap.SQUARE
        canvas.drawLine(50f,150f,400f,150f,paint)


    }


}
