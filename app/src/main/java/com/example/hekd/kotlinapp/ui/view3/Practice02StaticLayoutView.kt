package com.example.hekd.kotlinapp.ui.view3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

class Practice02StaticLayoutView : View {
    internal var textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    internal var text = "曾经沧海难为水\n除却巫山不是云"
    var mStaticLayout: StaticLayout? = null


    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        textPaint.textSize = 40f

        mStaticLayout = StaticLayout(text, textPaint, 300, Layout.Alignment.ALIGN_NORMAL, 1f, 0f, true)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，
        // 以绘制出带有换行的文字
        canvas.drawText(text, 50f, 100f, textPaint)
        canvas.save()
        canvas.translate(50f, 300f)
        mStaticLayout!!.draw(canvas)
        canvas.restore()
    }
}
