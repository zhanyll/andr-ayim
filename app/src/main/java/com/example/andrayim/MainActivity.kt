package com.example.andrayim

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.OutcomeReceiver
import android.widget.Toast
import com.example.andrayim.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receiver = binding.receiver.text.toString() // Вы берете значения из эдитТекстов в методе onCreate(),
        val subject = binding.subject.text.toString() // -> когда приложение ток запустилось
        val text = binding.text.text.toString() // -> на старте эдитТексты пустые и сохраняете пустые строки в переменные

        binding.btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            val receivers = receiver.split(",".toRegex()).toTypedArray()
            intent.putExtra(Intent.EXTRA_EMAIL, receivers) // и здесь передаете пустые строки -> ""
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, text)
            intent.type = "message/rfc822"

            if (intent.resolveActivity(packageManager) != null){
                startActivity(intent)
            } else {
                Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
