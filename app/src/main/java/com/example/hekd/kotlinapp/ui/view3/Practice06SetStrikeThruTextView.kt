package com.example.hekd.kotlinapp.ui.view3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice06SetStrikeThruTextView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var text = "Hello HenCoder"

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        paint.textSize = 60f

        // 使用 Paint.setStrikeThruText() 来设置删除线
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.isStrikeThruText=true
        canvas.drawText(text, 50f, 100f, paint)
    }
}
