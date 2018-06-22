package com.example.hekd.kotlinapp

import android.content.Context
import android.support.v7.widget.AppCompatSeekBar
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.SeekBar

/**
 * 这个类是用来做 ImageView 外部的可调整框架的，不必关注
 */
class Common01AdjustablePanel : RelativeLayout {
    internal lateinit var parentLayout: FrameLayout
    internal lateinit var heightBar: AppCompatSeekBar
    internal lateinit var widthBar: AppCompatSeekBar

    internal var bottomMargin = Utils.dpToPixel(48f)
    internal var minWidth = Utils.dpToPixel(80f)
    internal var minHeight = Utils.dpToPixel(100f)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        parentLayout = findViewById(R.id.parentLayout)
        widthBar = findViewById(R.id.widthBar)
        heightBar = findViewById(R.id.heightBar)

        val listener = object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, percent: Int, b: Boolean) {
                val layoutParams = parentLayout.layoutParams as RelativeLayout.LayoutParams
                layoutParams.width = (minWidth + (this@Common01AdjustablePanel.width - minWidth) * widthBar.progress / 100).toInt()
                layoutParams.height = (minHeight + (this@Common01AdjustablePanel.height.toFloat()
                        - bottomMargin - minHeight) * heightBar.progress / 100).toInt()
                parentLayout.layoutParams = layoutParams
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        }
        widthBar.setOnSeekBarChangeListener(listener)
        heightBar.setOnSeekBarChangeListener(listener)
    }
}
