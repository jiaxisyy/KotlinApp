package com.example.hekd.kotlinapp.ui.view7.practice01

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.RelativeLayout

import com.example.hekd.kotlinapp.R


class Practice01ArgbEvaluatorLayout : RelativeLayout {
    internal lateinit var view: Practice01ArgbEvaluatorView
    internal lateinit var animateBt: Button

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        view = findViewById<View>(R.id.objectAnimatorView) as Practice01ArgbEvaluatorView
        animateBt = findViewById<View>(R.id.animateBt) as Button

        animateBt.setOnClickListener {

            val objectAnimator = ObjectAnimator.ofInt(view, "color", -0x10000, -0xff0100)

            objectAnimator.setEvaluator(ArgbEvaluator())
            objectAnimator.duration = 2000
            objectAnimator.interpolator = LinearInterpolator()
            objectAnimator.start()
        }
    }
}
