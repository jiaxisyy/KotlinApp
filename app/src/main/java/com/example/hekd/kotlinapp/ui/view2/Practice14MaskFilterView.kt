package com.example.hekd.kotlinapp.ui.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.hekd.kotlinapp.R


class Practice14MaskFilterView : View {


    internal val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val normal = BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
    private val inner = BlurMaskFilter(50f, BlurMaskFilter.Blur.INNER)
    private val outer = BlurMaskFilter(50f, BlurMaskFilter.Blur.OUTER)
    private val solid = BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.what_the_fuck)

        paint.maskFilter = normal
        canvas!!.drawBitmap(bitmap, 100f, 100f, paint)
        paint.maskFilter = inner
        canvas.drawBitmap(bitmap, 600f, 100f, paint)
        paint.maskFilter = outer
        canvas.drawBitmap(bitmap, 100f, 600f, paint)
        paint.maskFilter = solid
        canvas.drawBitmap(bitmap, 600f, 600f, paint)

    }
}
