package com.example.andrayim

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn1 = findViewById<AppCompatButton>(R.id.btn_1)
        val btn2 = findViewById<AppCompatButton>(R.id.btn_2)
        val btn3 = findViewById<AppCompatButton>(R.id.btn_3)

        btn1.setOnClickListener(::onClick)
        btn2.setOnClickListener(::onClick)
        btn3.setOnClickListener(::onClick)
    }


    private fun onClick(view: View) {
        val container = findViewById<LinearLayout>(R.id.container)
        when (view.id) {
            R.id.btn_1 -> { container.setBackgroundColor(Color.parseColor("red"))}
            R.id.btn_2 -> { container.setBackgroundColor(Color.parseColor("yellow"))}
            R.id.btn_3 -> { container.setBackgroundColor(Color.parseColor("green"))}
        }
    }
}