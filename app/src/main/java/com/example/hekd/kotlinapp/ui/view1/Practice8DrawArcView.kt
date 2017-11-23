package com.example.hekd.kotlinapp.ui.view1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View

/**
 * Created by hekd on 2017/11/13.
 */
class Practice8DrawArcView : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //画弧形

        val paint = Paint()
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
        //连接圆心的扇形
        canvas!!.drawArc(200f, 100f, 800f, 500f, -110f, 100f, true, paint)
        //不连接圆心的扇形
        canvas.drawArc(200f, 100f, 800f, 500f, 20f, 140f, false, paint)
        //弧线
        paint.style=Paint.Style.STROKE
        canvas.drawArc(200f, 100f, 800f, 500f, 180f, 60f, false, paint)


    }

}