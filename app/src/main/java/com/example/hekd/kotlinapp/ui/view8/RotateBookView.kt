package com.example.hekd.kotlinapp.ui.view8

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.hekd.kotlinapp.R


/**
 * 仿翻书旋转
 * Created by hekd on 2018/2/1.
 */
class RotateBookView : View {
    /**Y轴旋转角度*/
    private var degreeY = 0f
    /**Z轴旋转角度*/
    private var degreeZ = 0f
    /**不变的Y轴角度*/
    private var fixDegreeY = 0f
    private var bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val camera = Camera()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val bitmapWidth = bitmap.width
        val bitmapHeight = bitmap.height
        val centerX = width / 2f
        val centerY = height / 2f
        val x = centerX - bitmapWidth / 2
        val y = centerY - bitmapHeight / 2

        //画变换的一半
        //先旋转，再裁切，再使用camera执行3D动效,**然后保存camera效果**,最后再旋转回来
        canvas!!.save()
        camera.save()
        canvas.translate(centerX, centerY)
        canvas.rotate(-degreeZ)
        camera.rotateY(degreeY)
        camera.applyToCanvas(canvas)
        //计算裁切参数时清注意，此时的canvas的坐标系已经移动
        canvas.clipRect(0f, -centerY, centerX, centerY)
        canvas.rotate(degreeZ)
        canvas.translate(-centerX, -centerY)
        camera.restore()
        canvas.drawBitmap(bitmap, x, y, paint)
        canvas.restore()

        //画不变换的另一半
        canvas.save()
        camera.save()
        canvas.translate(centerX, centerY)
        canvas.rotate(-degreeZ)
        //计算裁切参数时清注意，此时的canvas的坐标系已经移动
        canvas.clipRect(-centerX, -centerY, 0f, centerY)
        //此时的canvas的坐标系已经旋转，所以这里是rotateY
        camera.rotateY(fixDegreeY)
        camera.applyToCanvas(canvas)
        canvas.rotate(degreeZ)
        canvas.translate(-centerX, -centerY)
        camera.restore()
        canvas.drawBitmap(bitmap, x, y, paint)
        canvas.restore()


    }

    /**
     * 启动动画之前调用，把参数reset到初始状态
     */
    fun reset() {
        degreeY = 0f
        fixDegreeY = 0f
        degreeZ = 0f
    }


    fun setFixDegreeY(fixDegreeY: Float) {
        this.fixDegreeY = fixDegreeY
        invalidate()
    }


    fun setDegreeY(degreeY: Float) {
        this.degreeY = degreeY
        invalidate()
    }


    fun setDegreeZ(degreeZ: Float) {
        this.degreeZ = degreeZ
        invalidate()
    }

    fun setBitmap(bitmap: Bitmap) {
        this.bitmap = bitmap
        invalidate()
    }
}