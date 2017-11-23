package com.example.hekd.kotlinapp.ui.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Practice01LinearGradientView : View {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    // 用 Paint.setShader(shader) 设置一个 LinearGradient
    // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.isAntiAlias = true
        paint.shader = LinearGradient(100f, 100f, 200f, 200f, Color.parseColor("#E91E63"),Color.parseColor("#2196F3"),Shader.TileMode.MIRROR)
        canvas!!.drawCircle(300f, 300f, 200f, paint)
    }

}
