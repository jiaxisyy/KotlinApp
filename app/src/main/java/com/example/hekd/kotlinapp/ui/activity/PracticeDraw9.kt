package com.example.hekd.kotlinapp.ui.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.example.hekd.kotlinapp.R
import com.example.hekd.kotlinapp.ui.view8.RotateBookView


/**
 * Created by hekd on 2017/11/10.
 */
class PracticeDraw9 : AppCompatActivity() {
    val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotate_book)


        val rotateBookView = findViewById<RotateBookView>(R.id.rbv_main)
        val animator1 = ObjectAnimator.ofFloat(rotateBookView, "degreeY", 0f, -45f)
        animator1.duration = 1000
        animator1.startDelay = 500

        val animator2 = ObjectAnimator.ofFloat(rotateBookView, "degreeZ", 0f, 270f)
        animator2.duration = 10000
        animator2.startDelay = 500

        val animator3 = ObjectAnimator.ofFloat(rotateBookView, "fixDegreeY", 0f, 30f)
        animator3.duration = 500
        animator3.startDelay = 500

        val set = AnimatorSet()
        set.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                handler.postDelayed({
                    runOnUiThread {
                        rotateBookView.reset()
                        set.start()
                    }
                }, 500)
            }
        })
        set.playSequentially(animator1, animator2, animator3)
        set.start()
    }
}
