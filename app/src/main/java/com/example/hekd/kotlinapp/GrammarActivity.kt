package com.example.hekd.kotlinapp

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.example.hekd.kotlinapp.permission.PermissionUtils

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
        PermissionUtils.premissionPic(this, this)
        val btn_when = findViewById<Button>(R.id.btn_when)
        btn_when.setOnClickListener {
            when (x) {
                2 -> println(2)
                3 -> println(3)
            }
            x++
            applicationContext.longToast("hello world,x=" + x)
        }
    }

    fun Context.longToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun test2() {
        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener { longToast("heh") }

    }
}
