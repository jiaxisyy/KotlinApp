package com.example.hekd.kotlinapp.ui.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.hekd.kotlinapp.R


class Practice08XfermodeView : View {


    internal val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val saveLayer = canvas!!.saveLayer(null, null, Canvas.ALL_SAVE_FLAG)
        val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
        val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)


        val xfermode1 = PorterDuffXfermode(PorterDuff.Mode.SRC)
        val xfermode2 = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
        val xfermode3 = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)

        canvas.drawBitmap(bitmap1, 0f, 0f, paint)
        paint.xfermode = xfermode1
        canvas.drawBitmap(bitmap2, 0f, 0f, paint)
        paint.xfermode=null
        canvas.drawBitmap(bitmap1,bitmap1.width+100f,0f,paint)
        paint.xfermode=xfermode2
        canvas.drawBitmap(bitmap2,bitmap1.width+100f,0f,paint)
        paint.xfermode=null

        canvas.drawBitmap(bitmap1,0f,bitmap1.height+100f,paint)
        paint.xfermode=xfermode3
        canvas.drawBitmap(bitmap2,0f,bitmap1.height+100f,paint)
        paint.xfermode=null

        canvas.restoreToCount(saveLayer)
    }


}
