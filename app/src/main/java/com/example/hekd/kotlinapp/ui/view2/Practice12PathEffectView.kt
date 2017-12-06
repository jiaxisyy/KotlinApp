package com.example.hekd.kotlinapp.ui.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.hekd.kotlinapp.sum

class Practice12PathEffectView : View {
    private val cornerPathEffect = CornerPathEffect(10f)
    private val discretePathEffect = DiscretePathEffect(10f, 5f)
    private val dashPathEffect=DashPathEffect(floatArrayOf(20f,10f,5f,10f),0f)



    private var pathDashPathEffect:PathDashPathEffect?=null

    internal val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val path = Path()

        paint.style = Paint.Style.STROKE
        path.moveTo(50f, 100f)
        path.rLineTo(50f, 100f)
        path.rLineTo(100f, -150f)
        path.rLineTo(80f, 70f)
        path.rLineTo(50f, -100f)
        path.rLineTo(150f, 50f)
        canvas!!.drawPath(path, paint)
        canvas.save()

        canvas.translate(500f, 0f)
        paint.pathEffect = cornerPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()

        canvas.translate(0f, 300f)
        paint.pathEffect = discretePathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()

        canvas.translate(500f, 300f)
        paint.pathEffect = dashPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()


        val pathDath=Path()
//        pathDath.addCircle(10f,10f,10f,Path.Direction.CW)
        pathDath.lineTo(20f,-30f)
        pathDath.lineTo(40f,0f)
        pathDath.close()
        pathDashPathEffect= PathDashPathEffect(pathDath,50f,0f,PathDashPathEffect.Style.MORPH)
        canvas.translate(0f, 600f)
        paint.pathEffect = pathDashPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()

        val sumPathEffect = SumPathEffect(dashPathEffect, discretePathEffect)
        canvas.translate(500f, 600f)
        paint.pathEffect = sumPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()


        val composePathEffect = ComposePathEffect(dashPathEffect, discretePathEffect)
        canvas.translate(0f, 900f)
        paint.pathEffect = composePathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()












    }


}
