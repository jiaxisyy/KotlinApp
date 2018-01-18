package com.example.hekd.kotlinapp.ui.view6

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.*
import com.example.hekd.kotlinapp.R
import com.example.hekd.kotlinapp.Utils

class Practice06Duration : LinearLayout {
    internal lateinit var durationSb: SeekBar
    internal lateinit var durationValueTv: TextView
    internal lateinit var animateBt: Button
    internal lateinit var imageView: ImageView
    var translationState = 0
    private var translationStateCount = 2

    internal var duration = 300

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        durationSb = findViewById<View>(R.id.durationSb) as SeekBar
        durationValueTv = findViewById<View>(R.id.durationValueTv) as TextView
        durationValueTv.text = context.getString(R.string.ms_with_value, duration)
        durationSb.max = 10
        durationSb.progress = 1
        durationSb.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                duration = progress * 300
                durationValueTv.text = context.getString(R.string.ms_with_value, duration)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

        animateBt = findViewById<View>(R.id.animateBt) as Button
        imageView = findViewById<View>(R.id.imageView) as ImageView
        animateBt.setOnClickListener {
            // TODO 在这里处理点击事件，执行动画。记得使用 `setDuration(duration)` 来设置动画的时长。
            when (translationState) {
                0 -> imageView.animate().translationX(Utils.dpToPixel(150f)).duration = duration.toLong()
                1 -> imageView.animate().translationX(Utils.dpToPixel(0f)).duration = duration.toLong()
            }
            translationState++
            if (translationState == translationStateCount) {
                translationState = 0
            }

        }
    }
}
