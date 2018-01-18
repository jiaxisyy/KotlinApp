package com.example.hekd.kotlinapp.ui.view6

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ImageView

import com.example.hekd.kotlinapp.R
import com.example.hekd.kotlinapp.Utils


class Practice05MultiProperties : ConstraintLayout {
    internal lateinit var animateBt: Button
    internal lateinit var imageView: ImageView
    var translationState = 0
    private var translationStateCount = 2

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        animateBt = findViewById<View>(R.id.animateBt) as Button
        imageView = findViewById<View>(R.id.imageView) as ImageView
        imageView.scaleX = 0f
        imageView.scaleY = 0f
        imageView.alpha = 0f
        animateBt.setOnClickListener {
            // TODO 在这里处理点击事件，同时对多个属性做动画
            when (translationState) {
                0 -> imageView.animate().translationX(Utils.dpToPixel(150f)).scaleX(1f).scaleY(1f).rotation(720f).alpha(1f)
                1 -> imageView.animate().translationX(Utils.dpToPixel(0f)).scaleX(0f).scaleY(0f).rotation(0f).alpha(0f)

            }
            translationState++
            if (translationState == translationStateCount) {
                translationState = 0
            }

        }
    }
}
