package com.example.hekd.kotlinapp.ui.view4

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.hekd.kotlinapp.R

class Practice01ClipRectView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val left = (width - bitmap.width) / 2
        val top = (height - bitmap.height) / 2

        canvas.clipRect(Rect(left+50,top+50,left+300,top+200))
        canvas.drawBitmap(bitmap, left.toFloat(), top.toFloat(), paint)
    }
}
