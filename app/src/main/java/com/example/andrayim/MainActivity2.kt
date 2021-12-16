package com.example.andrayim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val txt = intent.getStringExtra("text")
        val activityText = findViewById<AppCompatTextView>(R.id.activity_txt)
        activityText.text = txt
    }
}