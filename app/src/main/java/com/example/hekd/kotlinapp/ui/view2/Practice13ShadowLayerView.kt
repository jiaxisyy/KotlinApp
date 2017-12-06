package com.example.hekd.kotlinapp.ui.view2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice13ShadowLayerView : View {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.textSize = 100f
        paint.setShadowLayer(10f, 5f, 5f, Color.RED)

        canvas!!.drawText("HELLO KOTLIN", 0f, 100f, paint)

    }


}
