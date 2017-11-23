package com.example.hekd.kotlinapp.ui.view1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View

/**
 * Created by hekd on 2017/11/13.
 */
class Practice5DrawOvalView : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //画椭圆
        val paint = Paint()
        paint.isAntiAlias=true
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        canvas!!.drawOval(100f, 100f, 500f, 300f, paint)


    }
}