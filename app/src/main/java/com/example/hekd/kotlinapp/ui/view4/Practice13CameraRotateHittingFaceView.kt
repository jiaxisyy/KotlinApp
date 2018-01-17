package com.example.hekd.kotlinapp.ui.view4

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.example.hekd.kotlinapp.R

class Practice13CameraRotateHittingFaceView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    internal var point = Point(200, 50)
    internal var camera = Camera()
    internal var matrix = Matrix()
    internal var degree: Int = 0
    internal var animator = ObjectAnimator.ofInt(this, "degree", 0, 360)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        val scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.width * 2, bitmap.height * 2, true)
        bitmap.recycle()
        bitmap = scaledBitmap

        animator.duration = 5000
        animator.interpolator = LinearInterpolator()
        val displayMetrics = resources.displayMetrics
        val newZ = -displayMetrics.density * 6
        camera.setLocation(0f, 0f, newZ)
        animator.repeatCount = ValueAnimator.INFINITE
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
        val centerX = point.x + bitmapWidth / 2
        val centerY = point.y + bitmapHeight / 2
        camera.save()
        matrix.reset()
        camera.rotateX(degree.toFloat())
        camera.getMatrix(matrix)
        camera.restore()
        matrix.preTranslate((-centerX).toFloat(), (-centerY).toFloat())
        matrix.postTranslate(centerX.toFloat(), centerY.toFloat())
        canvas.save()
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap, point.x.toFloat(), point.y.toFloat(), paint)
        canvas.restore()
    }
}