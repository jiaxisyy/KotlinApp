package com.example.hekd.kotlinapp.ui.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * Created by hekd on 2017/11/13.
 */
class Practice11PieChartView : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //画分析饼状图
        val path = Path()
        val paint = Paint()
        canvas!!.drawColor(Color.parseColor("#506E79"))

        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
        val rectF1 = RectF(200f, 200f, 600f, 600f)

        //各个扇形角度
        val arrayListOfAngles = arrayListOf(45f, 10f, 8f, 45f, 100f)
        //各个扇形对应的颜色
        val arrayListOfColors = arrayListOf(Color.BLACK, Color.YELLOW, Color.RED, Color.GREEN, Color.BLUE, Color.CYAN)
        //扇形名称
        val arrayListOfNames = arrayListOf("A", "B", "C", "D", "E", "F")

        //起始角度
        val STARTANGLE = -45f
        //当前角度
        var NOWANGLE = 0f
        // 偏移量
        val OFFSETANGLE = 3f
        //圆半径
        val RADIUS = 200f

        for (i in 0..4) {
            paint.color = arrayListOfColors[i]
            if (i == 0) {
                canvas.drawArc(rectF1, STARTANGLE, arrayListOfAngles[i], true, paint)
                NOWANGLE = STARTANGLE + arrayListOfAngles[i] + OFFSETANGLE
            } else {
                canvas.drawArc(rectF1, NOWANGLE, arrayListOfAngles[i], true, paint)
                NOWANGLE += arrayListOfAngles[i] + OFFSETANGLE
            }
            //角度=弧度*180/Math.PI
            paint.color = Color.WHITE
            val halfAngle = NOWANGLE - OFFSETANGLE - arrayListOfAngles[i] / 2
            //画线
            val lineStartX = RADIUS * Math.cos(halfAngle / 180 * Math.PI) + 400f//圆弧中心点的X坐标
            val lineStartY = RADIUS * Math.sin(halfAngle / 180 * Math.PI) + 400f//圆弧中心点的Y坐标
            val lineEndX = (RADIUS + 50) * Math.cos(halfAngle / 180 * Math.PI) + 400f//圆弧中心点的X坐标
            val lineEndY = (RADIUS + 50) * Math.sin(halfAngle / 180 * Math.PI) + 400f//圆弧中心点的Y坐标
            canvas.drawLine(lineStartX.toFloat(), lineStartY.toFloat(), lineEndX.toFloat(), lineEndY.toFloat(), paint)
            if (lineEndX - lineStartX > 0) {//右边横线
                canvas.drawLine(lineEndX.toFloat(), lineEndY.toFloat(), (lineEndX + 50).toFloat(), lineEndY.toFloat(), paint)
                //右边的字
                canvas.drawText(arrayListOfNames[i], (lineEndX + 50 + 10).toFloat(), lineEndY.toFloat(), paint)
            } else {
                canvas.drawLine(lineEndX.toFloat(), lineEndY.toFloat(), (lineEndX - 50).toFloat(), lineEndY.toFloat(), paint)

                //左边的字
                canvas.drawText(arrayListOfNames[i], (lineEndX - 10 - 50 - paint.measureText(arrayListOfNames[i])).toFloat(), lineEndY.toFloat(), paint)
            }

        }
        //最后一个扇形
        paint.color = Color.DKGRAY
        canvas.translate((-0.05 * 400).toFloat(), (-0.05 * 400).toFloat())
        canvas.drawArc(rectF1, NOWANGLE - OFFSETANGLE, 360 - Math.abs(NOWANGLE) + OFFSETANGLE + STARTANGLE, true, paint)
        val halfEndAngle = NOWANGLE - OFFSETANGLE + (360 - Math.abs(NOWANGLE) + OFFSETANGLE + STARTANGLE) / 2
        val lineEndStartX = RADIUS * Math.cos(halfEndAngle / 180 * Math.PI) + 400f
        val lineEndStartY = RADIUS * Math.sin(halfEndAngle / 180 * Math.PI) + 400f
        val lineEndEndX = (RADIUS + 50) * Math.cos(halfEndAngle / 180 * Math.PI) + 400f
        val lineEndEndY = (RADIUS + 50) * Math.sin(halfEndAngle / 180 * Math.PI) + 400f
        paint.color = Color.WHITE
        canvas.drawLine(lineEndStartX.toFloat(), lineEndStartY.toFloat(), lineEndEndX.toFloat(), lineEndEndY.toFloat(), paint)
        canvas.drawLine(lineEndEndX.toFloat(), lineEndEndY.toFloat(), (lineEndEndX - 50).toFloat(), lineEndEndY.toFloat(), paint)
        //左边的字
        canvas.drawText(arrayListOfNames[arrayListOfNames.size-1], (lineEndEndX - 10 - 50 - paint.measureText(arrayListOfNames[arrayListOfNames.size-1])).toFloat(), lineEndEndY.toFloat(), paint)

    }

}