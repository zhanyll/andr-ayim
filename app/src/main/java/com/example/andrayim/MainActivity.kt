package com.example.andrayim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andrayim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            val text = binding.editText.text.toString()
            val result = replaceInt(text)
            binding.wordKotlin.text = result
        }
    }

    private fun replaceInt(text: String): String {
        val nums = mapOf(0 to "zero",1 to "one", 2 to "two", 3 to "three", 4 to "four", 5 to "five", 6 to "six", 7 to "seven", 8 to "eight", 9 to "nine")
        var str = ""
        for (i in text) {
            var e = nums[i.toString().toInt()]
            str = "$str $e "
        }
        return str
    }
}