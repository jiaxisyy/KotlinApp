package com.example.hekd.kotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.hekd.kotlinapp.ui.activity.PracticeDraw
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        first()
    }

    private fun first() {
        findViewById(R.id.btn_helloKotlin).setOnClickListener {
            startActivity(Intent(this, GrammarActivity::class.java))
        }


        btn_openDraw1.setOnClickListener {
            startActivity(Intent(this@MainActivity, PracticeDraw::class.java))
        }

    }
}
