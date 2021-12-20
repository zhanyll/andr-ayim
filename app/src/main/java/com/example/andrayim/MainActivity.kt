package com.example.andrayim

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.OutcomeReceiver
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.andrayim.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val receiver = findViewById<AppCompatEditText>(R.id.email)
        val subject = findViewById<AppCompatEditText>(R.id.subject)
        val text = findViewById<AppCompatEditText>(R.id.text)
        val btn = findViewById<AppCompatButton>(R.id.btn)

        btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("mailto:")
//            val receivers = receiver.text.toString().split(",".toRegex()).toTypedArray()
            intent.putExtra(Intent.EXTRA_EMAIL, receiver.text)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject.text)
            intent.putExtra(Intent.EXTRA_TEXT, text.text)
            intent.type = "message/rfc822"

            if (intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            } else {
                Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}