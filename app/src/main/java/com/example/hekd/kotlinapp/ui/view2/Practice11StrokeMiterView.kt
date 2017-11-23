package com.example.hekd.kotlinapp.ui.view2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class Practice11StrokeMiterView : View {
    internal val paint = Paint(Paint.ANTI_ALIAS_FLAG)


    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas!!.save()
        val path = Path()

        path.rLineTo(200f, 0f)
        path.rLineTo(-150f, 100f)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20f

        canvas.translate(100f, 100f)
        paint.strokeMiter = 1f
        canvas.drawPath(path, paint)

        canvas.translate(300f, 0f)
        paint.strokeMiter = 3f
        canvas.drawPath(path, paint)

        canvas.translate(300f, 0f)

        paint.strokeMiter = 5f
        canvas.drawPath(path, paint)


    }
}
