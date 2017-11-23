package com.example.hekd.kotlinapp.ui.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

import com.example.hekd.kotlinapp.R


class Practice06LightingColorFilterView : View {

    internal val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 第一个 LightingColorFilter：去掉红色部分
        val colorFilter1 = LightingColorFilter(0x00ffff, 0x000000)
        paint.colorFilter = colorFilter1
        canvas!!.drawBitmap(BitmapFactory.decodeResource(resources,R.drawable.batman),0f,0f,paint)
        // 第二个 LightingColorFilter：增强绿色部分
        val colorFilter2 = LightingColorFilter(0xffffff, 0x003000)
        paint.colorFilter=colorFilter2
        canvas.drawBitmap(BitmapFactory.decodeResource(resources,R.drawable.batman),BitmapFactory.decodeResource(resources,R.drawable.batman).width+100f,0f,paint)


    }


}
