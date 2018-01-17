package com.example.hekd.kotlinapp.ui.view4

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.hekd.kotlinapp.R

class Practice04ScaleView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    internal var point1 = Point(200, 200)
    internal var point2 = Point(600, 200)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Canvas.scale(float sx, float sy, float px, float py) 放缩
        // 参数里的 sx sy 是横向和纵向的放缩倍数； px py 是放缩的轴心。
        canvas.save()
        canvas.scale(1.5f,1.5f,point1.x+bitmap.width/2f,point1.y+bitmap.height/2f)
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()
        canvas.scale(0.5f,2f,point2.x+bitmap.width/2f,point2.y+bitmap.height/2f)
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
    }
}
