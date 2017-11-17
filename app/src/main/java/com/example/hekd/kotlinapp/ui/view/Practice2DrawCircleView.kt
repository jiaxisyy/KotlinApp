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
class Practice2DrawCircleView : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint()
        //开启抗锯齿
        paint.isAntiAlias = true
        //黑色实心圆
        paint.color = Color.BLACK
        canvas!!.drawCircle(width / 4f, height / 4f, 150f, paint)
        //黑色空心圆
        paint.style = Paint.Style.STROKE

        canvas!!.drawCircle(width * 3 / 4f, height / 4f, 150f, paint)
        //蓝色实心圆
        paint.color = Color.BLUE
        paint.style = Paint.Style.FILL
        canvas.drawCircle(width / 4f, height * 3 / 4f, 150f, paint)
        //黑色圆环
        val path = Path()
        paint.color = Color.BLACK
        //CW顺时针,CCW逆时针
        path.addCircle(width * 3 / 4f, height * 3 / 4f, 150f, Path.Direction.CW)
        path.addCircle(width * 3 / 4f, height * 3 / 4f, 120f, Path.Direction.CW)
        //交叉填充
        //even - odd rule （ 奇偶原则 ）：对于平面中的任意一点，向任意方向射出一条射线，
        // 这条射线和图形相交的次数（相交才算，相切不算哦）如果是奇数，则这个点被认为在图形内部，
        // 是要被涂色的区域；如果是偶数，则这个点被认为在图形外部，是不被涂色的区域。还以左右相交的双圆为例
        path.fillType = Path.FillType.EVEN_ODD
        canvas.drawPath(path, paint)
    }
}