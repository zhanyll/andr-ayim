package com.example.andrayim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var text: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        text = findViewById(R.id.activity2_text)
        val txt = intent.getStringExtra("key")
        text.text = "Activity - $txt"
    }
}