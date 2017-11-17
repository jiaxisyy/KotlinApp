package com.example.hekd.kotlinapp.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * Created by hekd on 2017/11/13.
 */
class Practice10HistogramView : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //树状图
        val path = Path()
        val paint = Paint()

        paint.color = Color.WHITE
        canvas!!.drawColor(Color.parseColor("#506E79"))
        paint.style = Paint.Style.STROKE
        path.moveTo(100f, 100f)
        path.lineTo(100f, 600f)
        path.rLineTo(800f, 0f)
        //横纵坐标标注
        paint.textSize = 20f
        canvas.drawText("X", 90f, 100f, paint)
        canvas.drawText("Y", 900f, 620f, paint)


        //x坐标名称
        val arrayListOf = arrayListOf("Mon", "Tues", "Wed", "Thur", "Fri", "Sat", "Sun")
        //各个柱状高度
        val arrayListOfHeight = arrayListOf(50f, 200f, 300f, 400f, 100f, 500f, 150f)
        // 空隙宽度
        val widthOffset = 20
        //柱状宽度
        val widthRect = (800 - (arrayListOf.size + 1) * widthOffset) / arrayListOf.size

        //画x坐标
        for (i in 0..6) {
            //x坐标=初始100+前面的空隙宽度+前面的柱状宽度+柱状宽度/2-字体宽度/2
            canvas.drawText(arrayListOf[i], 100 + (i + 1) * widthOffset + widthRect * i + widthRect / 2f-(paint.measureText(arrayListOf[i])/2), 620f, paint)
        }
        canvas.drawPath(path, paint)
        paint.color = Color.GREEN
        paint.style=Paint.Style.FILL

        //画柱状图
        for (i in 0..6) {
            canvas.drawRect(100f + (i + 1) * widthOffset + widthRect * i, 600-arrayListOfHeight[i], 100f + (i + 1) * widthOffset + widthRect * i + widthRect, 600f, paint)
        }
    }
}