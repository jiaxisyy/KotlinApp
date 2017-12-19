package com.example.hekd.kotlinapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.hekd.kotlinapp.ai.VoiceRecognitionActivity
import com.example.hekd.kotlinapp.ui.activity.PracticeDraw1
import com.example.hekd.kotlinapp.ui.activity.PracticeDraw2
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        first()
    }

    private fun first() {
        btn_helloKotlin.setOnClickListener {
            startActivity(Intent(this, GrammarActivity::class.java))
        }
        btn_openDraw1.setOnClickListener {
            startActivity(Intent(this@MainActivity, PracticeDraw1::class.java))
        }
        btn_openDraw2.setOnClickListener {
            startActivity(Intent(this@MainActivity, PracticeDraw2::class.java))
        }
        btn_voice.setOnClickListener {
            //语音识别
            startActivity(Intent(this@MainActivity, VoiceRecognitionActivity::class.java))
        }

    }
}
