package com.example.hekd.kotlinapp.ui.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.hekd.kotlinapp.R

class Practice05ComposeShaderView : View {
    internal val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader
        // 用 Paint.setShader(shader) 设置一个 ComposeShader
        // Shader 1: BitmapShader 图片：R.drawable.batman
        // Shader 2: BitmapShader 图片：R.drawable.batman_logo

        setLayerType(LAYER_TYPE_SOFTWARE,null)

        val decodeResource1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
        val shader1 = BitmapShader(decodeResource1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        val decodeResource2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
        val shader2 = BitmapShader(decodeResource2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        paint.shader = ComposeShader(shader1, shader2, PorterDuff.Mode.DST_IN)
        canvas!!.drawCircle(200f, 200f, 200f, paint)
    }


}
