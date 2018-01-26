package com.example.hekd.kotlinapp.ui.view7

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout

import com.example.hekd.kotlinapp.R

class Practice04PropertyValuesHolderLayout : RelativeLayout {
    internal lateinit var view: View
    internal lateinit var animateBt: Button

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        view = findViewById(R.id.objectAnimatorView)
        animateBt = findViewById<View>(R.id.animateBt) as Button

        animateBt.setOnClickListener {
            // 使用 PropertyValuesHolder.ofFloat() 来创建不同属性的动画值方案
            // 第一个： scaleX 从 0 到 1
            // 第二个： scaleY 从 0 到 1
            // 第三个： alpha 从 0 到 1
            val valuesHolder1 = PropertyValuesHolder.ofFloat("scaleX", 0f, 1f)
            val valuesHolder2 = PropertyValuesHolder.ofFloat("scaleY", 0f, 1f)
            val valuesHolder3 = PropertyValuesHolder.ofFloat("alpha", 0f, 1f)

            val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, valuesHolder1, valuesHolder2, valuesHolder3)
            objectAnimator.duration=5*1000
            objectAnimator.start()
            // 然后，用 ObjectAnimator.ofPropertyValuesHolder() 把三个属性合并，创建 Animator 然后执行
        }
    }
}
