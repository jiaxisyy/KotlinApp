package com.example.hekd.kotlinapp.ui.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.hekd.kotlinapp.R

class Practice04BitmapShaderView : View {

    internal val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 用 Paint.setShader(shader) 设置一个 BitmapShader
        // Bitmap: R.drawable.batman

        paint.shader = BitmapShader(BitmapFactory.decodeResource(resources, R.drawable.batman), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        canvas!!.drawCircle(200f, 200f, 200f, paint)
    }


}
