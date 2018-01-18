package com.example.hekd.kotlinapp.ui.view6

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import com.example.hekd.kotlinapp.R


class Practice04Alpha : RelativeLayout {
    internal lateinit var animateBt: Button
    internal lateinit var imageView: ImageView
    var translationState=0
    private var translationStateCount =2
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        animateBt = findViewById<View>(R.id.animateBt) as Button
        imageView = findViewById<View>(R.id.imageView) as ImageView

        animateBt.setOnClickListener {
            // TODO 在这里处理点击事件，通过 View.animate().alpha() 来改变 View 的透明度
            when (translationState) {
                0 -> imageView.animate().alpha(0f)
                1 -> imageView.animate().alpha(1f)
            }
            translationState++
            if (translationState == translationStateCount) {
                translationState = 0
            }
        }
    }
}