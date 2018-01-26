package com.example.hekd.kotlinapp.ui.view6.practice08

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

import com.example.hekd.kotlinapp.Utils.dpToPixel


class Practice08ObjectAnimatorView : View {
    internal val radius = dpToPixel(80f)

    internal var arcRectF = RectF()
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    // TODO 为 progress 添加 getter 和 setter 方法（setter 方法记得加 invalidate()）
    internal var progress = 0f

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    init {
        paint.textSize = 50f
        paint.textAlign = Paint.Align.CENTER
    }

    fun setProgress(progress: Float) {
        this.progress = progress
        invalidate()
    }
    fun getProgress()=progress

    public override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val centerX = width / 2
        val centerY = height / 2

        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeWidth = 50f
        paint.style=Paint.Style.STROKE
        paint.color = Color.RED
        arcRectF.set(centerX-radius,centerY-radius,centerX+radius,centerY+radius)

        // 当使用初始120时,联想手机出现了初始化为一个整圆,其他手机无
        canvas.drawArc(arcRectF,135f, (progress*3.6).toFloat(),false,paint)

        paint.color=Color.WHITE
        paint.style=Paint.Style.FILL
        canvas.drawText("${progress.toInt()}%", centerX.toFloat(), centerY - (paint.ascent() + paint.descent()) / 2,paint)
    }
}
