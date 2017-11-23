package com.example.hekd.kotlinapp.ui.view1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by hekd on 2017/11/13.
 */
class Practice4DrawPointView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //画点
        val paint = Paint()
        paint.color=Color.BLACK
        paint.strokeWidth=50f
//        paint.style=Paint.Style.STROKE
        paint.strokeCap=Paint.Cap.ROUND
        canvas!!.drawPoint(width / 2f - 100, height / 2f, paint)
    }
}