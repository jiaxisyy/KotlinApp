package com.example.hekd.kotlinapp.ui.view6

import android.content.Context
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout

import com.example.hekd.kotlinapp.R
import com.example.hekd.kotlinapp.Utils


class Practice02Rotation : RelativeLayout {
    internal lateinit var animateBt: Button
    internal lateinit var imageView: ImageView
    var translationState=0
    private var translationStateCount = if (SDK_INT > Build.VERSION_CODES.LOLLIPOP) 6 else 4
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        animateBt = findViewById<View>(R.id.animateBt) as Button
        imageView = findViewById<View>(R.id.imageView) as ImageView

        animateBt!!.setOnClickListener {
            // // TODO 在这里处理点击事件，通过 View.animate().rotation/X/Y() 来让 View 旋转
            when (translationState) {
                0 -> imageView.animate().rotation(Utils.dpToPixel(100f))
                1 -> imageView.animate().rotation(0f)
                2 -> imageView.animate().rotationX(Utils.dpToPixel(50f))
                3 -> imageView.animate().rotationX(0f)
                4 -> imageView.animate().rotationY(Utils.dpToPixel(15f))
                5 -> imageView.animate().rotationY(0f)
            }
            translationState++
            if (translationState == translationStateCount) {
                translationState = 0

            }

        }
    }
}