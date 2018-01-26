package com.example.hekd.kotlinapp.ui.view7.practice03

import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.content.Context
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.RelativeLayout

import com.example.hekd.kotlinapp.R


class Practice03OfObjectLayout : RelativeLayout {
    internal lateinit var view: Practice03OfObjectView
    internal lateinit var animateBt: Button

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        view = findViewById<View>(R.id.objectAnimatorView) as Practice03OfObjectView
        animateBt = findViewById<View>(R.id.animateBt) as Button

        animateBt.setOnClickListener {
            val animator = ObjectAnimator.ofObject(view, "position",
                    PointFEvaluator(), PointF(0f, 0f), PointF(1f, 1f))
            animator.interpolator = LinearInterpolator()
            animator.duration = 1000
            animator.start()

        }
    }

    private inner class PointFEvaluator : TypeEvaluator<PointF> {
        internal var newPoint = PointF()
        // 重写 evaluate() 方法，让 PointF 可以作为属性来做动画
        override fun evaluate(fraction: Float, startValue: PointF, endValue: PointF): PointF {
            val x = startValue.x + fraction * (endValue.x - startValue.x)
            val y = startValue.y + fraction * (endValue.y - startValue.y)
            newPoint.set(x, y)
            return newPoint
        }
    }
}
