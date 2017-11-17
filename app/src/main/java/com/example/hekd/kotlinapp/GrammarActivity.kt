package com.example.hekd.kotlinapp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

/**
 *
 * kotlin语法练习2017.9.2
 */
class GrammarActivity : AppCompatActivity() {
    var x = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammar)
        test_when()
    }

    private fun test_when() {
        val btn_when = findViewById(R.id.btn_when) as Button
        btn_when.setOnClickListener {


            when (x) {
                2 -> println(2)
                3 -> println(3)
            }
            x++
            applicationContext.longToast("hello world,x=" + x)
        }

//        longToast("hello")
    }

    fun Context.longToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun test2(){
        val button = findViewById(R.id.button2) as Button
        button.setOnClickListener{longToast("heh")}

    }
}
