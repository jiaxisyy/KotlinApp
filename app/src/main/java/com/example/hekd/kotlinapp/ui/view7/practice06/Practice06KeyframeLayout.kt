package com.example.hekd.kotlinapp.ui.view7.practice06

import android.animation.Keyframe
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout

import com.example.hekd.kotlinapp.R


class Practice06KeyframeLayout : RelativeLayout {
    internal lateinit var view: Practice06KeyframeView
    internal lateinit var animateBt: Button

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        view = findViewById<View>(R.id.objectAnimatorView) as Practice06KeyframeView
        animateBt = findViewById<View>(R.id.animateBt) as Button

        animateBt.setOnClickListener {
            // 使用 Keyframe.ofFloat() 来为 view 的 progress 属性创建关键帧
            // 初始帧：progress 为 0
            // 时间进行到一般：progress 为 100
            // 结束帧：progress 回落到 80
            // 使用 PropertyValuesHolder.ofKeyframe() 来把关键帧拼接成一个完整的属性动画方案
            // 使用 ObjectAnimator.ofPropertyValuesHolder() 来创建动画


            val ofFloat1 = Keyframe.ofFloat(0f, 0f)
            val ofFloat2 = Keyframe.ofFloat(0.5f, 100f)
            val ofFloat3 = Keyframe.ofFloat(1f, 80f)

            val propertyValuesHolder = PropertyValuesHolder.ofKeyframe("progress", ofFloat1, ofFloat2, ofFloat3)
            val animator = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolder)
            animator.duration = 2000
            animator.interpolator = FastOutSlowInInterpolator()
            animator.start()
        }
    }
}
