package com.example.hekd.kotlinapp.ui.view2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class Practice10StrokeJoinView : View {
    internal val paint = Paint(Paint.ANTI_ALIAS_FLAG)


    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas!!.save()

        val path = Path()
        paint.strokeWidth = 20f
        paint.style = Paint.Style.STROKE
        path.moveTo(100f, 100f)
        path.rLineTo(200f, 0f)
        path.rLineTo(-100f, 100f)
        paint.strokeJoin=Paint.Join.MITER
        canvas.drawPath(path, paint)
        canvas.translate(300f,0f)
        paint.strokeJoin=Paint.Join.ROUND
        canvas.drawPath(path, paint)
        canvas.translate(300f,0f)
        paint.strokeJoin=Paint.Join.BEVEL
        canvas.drawPath(path, paint)
        canvas.restore()
    }


}
