package com.example.hekd.kotlinapp.ui.view4

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.example.hekd.kotlinapp.R

class Practice14FlipboardView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    internal var camera = Camera()
    internal var degree: Int = 0
    internal var animator = ObjectAnimator.ofInt(this, "degree", 0, 180)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {

        animator.duration = 2500
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = ValueAnimator.INFINITE
        animator.repeatMode = ValueAnimator.REVERSE
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animator.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator.end()
    }

    fun setDegree(degree: Int) {
        this.degree = degree
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val bitmapWidth = bitmap.width
        val bitmapHeight = bitmap.height
        val centerX = width / 2
        val centerY = height / 2
        val x = centerX - bitmapWidth / 2
        val y = centerY - bitmapHeight / 2

        // 绘制上部分
        canvas.save()
        canvas.clipRect(Rect(0, 0, width, centerY))
        canvas.drawBitmap(bitmap, x.toFloat(), y.toFloat(), paint)
        canvas.restore()

        // 绘制下部分
        if (degree < 90) {
            canvas.clipRect(0, centerY, width, height)
        } else {
            canvas.clipRect(Rect(0, 0, width, centerY))
        }

        camera.save()
        camera.rotateX(degree.toFloat())
        canvas.translate(centerX.toFloat(), centerY.toFloat())
        camera.applyToCanvas(canvas)
        canvas.translate(-centerX.toFloat(),-centerY.toFloat())
        camera.restore()
        canvas.drawBitmap(bitmap,x.toFloat(),y.toFloat(),paint)

    }
}
