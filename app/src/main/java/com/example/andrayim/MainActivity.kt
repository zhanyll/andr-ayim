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
import java.lang.reflect.Executable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val receiver = findViewById<AppCompatEditText>(R.id.email)
        val subject = findViewById<AppCompatEditText>(R.id.subject)
        val text = findViewById<AppCompatEditText>(R.id.text)
        val btn = findViewById<AppCompatButton>(R.id.btn)

        btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            val receivers = receiver.text.toString().split(",".toRegex()).toTypedArray()
            intent.putExtra(Intent.EXTRA_EMAIL, receivers)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject.text.toString())
            intent.putExtra(Intent.EXTRA_TEXT, text.text.toString())

            try{
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "something went wrong: $e", Toast.LENGTH_SHORT).show()
            }
        }
    }
}