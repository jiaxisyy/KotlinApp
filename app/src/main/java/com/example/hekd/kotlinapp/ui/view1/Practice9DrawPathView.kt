package com.example.hekd.kotlinapp.ui.view1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View
import android.graphics.RectF



/**
 * Created by hekd on 2017/11/13.
 */
class Practice9DrawPathView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //画爱心
        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
        paint.color = Color.BLACK

        val path = Path()
        path.addArc(200F, 200F, 400F, 400F, -225F, 225F)
        path.arcTo(400F, 200F, 600F, 400F, -180F, 225F, false)
        path.lineTo(400F, 542F)
        canvas!!.drawPath(path, paint)
        //多种绘制

        val rectF1 = RectF(100f, 800f, 300f, 1000f)
        val rectF2 = RectF(300f, 800f, 500f, 1000f)
        paint.style=Paint.Style.STROKE
        path.addArc(rectF1,135f,225f)
        path.arcTo(rectF2,-180f,225f,false)
        path.lineTo(300f,1100f)
        path.close()
        canvas.drawPath(path,paint)


    }
}