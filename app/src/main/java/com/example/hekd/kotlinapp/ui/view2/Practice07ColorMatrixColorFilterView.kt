package com.example.hekd.kotlinapp.ui.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.hekd.kotlinapp.R


class Practice07ColorMatrixColorFilterView : View {
    internal val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // 使用 setColorFilter() 设置一个 ColorMatrixColorFilter
        // 用 ColorMatrixColorFilter.setSaturation() 把饱和度去掉
        val decodeResource = BitmapFactory.decodeResource(resources, R.drawable.batman)
        val matrix = ColorMatrix()
        matrix.setSaturation(10f)

        val colorMatrixColorFilter = ColorMatrixColorFilter(matrix)
        paint.colorFilter = colorMatrixColorFilter
        canvas!!.drawBitmap(decodeResource, 0f, 0f, paint)


    }


}
