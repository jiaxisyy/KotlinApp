package com.example.hekd.kotlinapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.hekd.kotlinapp.ai.VoiceRecognitionActivity
import com.example.hekd.kotlinapp.ui.activity.PracticeDraw1
import com.example.hekd.kotlinapp.ui.activity.PracticeDraw2
import com.example.hekd.kotlinapp.ui.activity.PracticeDraw3
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        when (p0!!) {
            btn_helloKotlin -> startActivity(Intent(this, GrammarActivity::class.java))
            btn_openDraw1 -> startActivity(Intent(this@MainActivity, PracticeDraw1::class.java))
            btn_openDraw2 -> startActivity(Intent(this@MainActivity, PracticeDraw2::class.java))
            btn_openDraw3 -> startActivity(Intent(this@MainActivity, PracticeDraw3::class.java))
            btn_voice -> startActivity(Intent(this@MainActivity, VoiceRecognitionActivity::class.java))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
    }

    private fun bindView() {
        btn_helloKotlin.setOnClickListener(this)
        btn_openDraw1.setOnClickListener(this)
        btn_openDraw2.setOnClickListener(this)
        btn_openDraw3.setOnClickListener(this)
        btn_voice.setOnClickListener(this)
    }


}
