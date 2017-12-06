package com.example.hekd.kotlinapp.ui.view2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class Practice16TextPathView : View {


    internal val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal val pathPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    val hello = "HELLO KOTLIN"
    val path = Path()
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)



        paint.textSize = 120f
        pathPaint.style = Paint.Style.STROKE
        canvas!!.drawText(hello,50f,100f,paint)
        paint.getTextPath(hello, 0, hello.length, 50f, 300f, path)
        canvas.drawPath(path, pathPaint)

    }
}
