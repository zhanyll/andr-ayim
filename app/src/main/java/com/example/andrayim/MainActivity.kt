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
    private lateinit var binding: ActivityMainBinding // эта переменная не используется нигде, потому что ниже создала переменную с таким же названим

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater) // val binding - закрыла переменную выше
        setContentView(binding.root)

        val receiver = binding.receiver.text.toString()
        val subject = binding.subject.text.toString()
        val text = binding.text.text.toString()

        binding.btn.setOnClickListener { onClick(receiver, subject, text) }
    }

    fun onClick(receiver: String, subject: String, text: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:")
        intent.type = "text/plain"

        intent.putExtra(Intent.EXTRA_EMAIL, receiver) // не подставляется
        intent.putExtra(Intent.EXTRA_SUBJECT, subject) // не подставляется
        intent.putExtra(Intent.EXTRA_TEXT, text) // не подставляется

        try {
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "$e", Toast.LENGTH_SHORT).show()
        }
    }
}
