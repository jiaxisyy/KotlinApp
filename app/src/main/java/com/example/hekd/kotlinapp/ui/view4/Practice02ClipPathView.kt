package com.example.hekd.kotlinapp.ui.view4

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.hekd.kotlinapp.R

class Practice02ClipPathView : View {
    internal var paint = Paint()
    internal var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    internal var point1 = Point(200, 200)
    internal var point2 = Point(600, 200)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val path1=Path()
        val path2=Path()

        canvas.save()
        path1.addCircle(point1.x+200f,point1.y+200f,150f,Path.Direction.CW)
        path2.addCircle(point2.x+200f,point2.y+200f,150f,Path.Direction.CW)
        path2.fillType=Path.FillType.INVERSE_WINDING
        canvas.clipPath(path1)
        canvas.drawBitmap(bitmap, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()
        canvas.clipPath(path2)
        canvas.drawBitmap(bitmap, point2.x.toFloat(), point2.y.toFloat(), paint)
    }
}
