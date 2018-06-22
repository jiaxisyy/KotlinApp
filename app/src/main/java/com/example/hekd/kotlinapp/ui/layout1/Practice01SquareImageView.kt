package com.example.hekd.kotlinapp.ui.layout1

import android.content.Context
import android.util.AttributeSet

/**
 * 需要把它写成正方形的 ImageView
 */
class Practice01SquareImageView : android.support.v7.widget.AppCompatImageView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    /**
     * 重写 onMeasure()，调整尺寸，让 ImageView 总是正方形
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        // 先用 getMeasuredWidth() 和 getMeasuredHeight() 取到 super.onMeasure() 的计算结果
        var measuredHeight = measuredHeight
        var measuredWidth = measuredWidth

        // 然后通过计算，让宽度和高度一致

        if (measuredHeight > measuredWidth) {
            measuredHeight = measuredWidth
        } else {
            measuredWidth = measuredHeight
        }
        // 再用 setMeasuredDimension(width, height) 来保存最终的宽度和高度

        setMeasuredDimension(measuredWidth,measuredHeight)
    }
}
