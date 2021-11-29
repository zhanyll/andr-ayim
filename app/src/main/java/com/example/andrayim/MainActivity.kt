package com.example.andrayim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.PackageManagerCompat.LOG_TAG

class MainActivity : AppCompatActivity() {
    private lateinit var num: AppCompatTextView
    private var add = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num = findViewById(R.id.num)

        val btn1 = findViewById<AppCompatButton>(R.id.btn_1)
        val btn2 = findViewById<AppCompatButton>(R.id.btn_2)

        btn1.setOnClickListener{
            add++
            num.text = "$add"
        }

        btn2.setOnClickListener{
            add = 0
            num.text = "$add"
        }

        if (savedInstanceState != null) {
            add = savedInstanceState.getInt("saved")
            num.text = "$add"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("saved", add)
    }
}