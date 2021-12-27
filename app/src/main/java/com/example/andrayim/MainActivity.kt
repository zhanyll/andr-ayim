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
            val text = binding.editText.text.toString().trim()
//            val oo = "o".toRegex()
//            val result = oo.findAll(text).count()
            val result = findO(text)
            binding.txt.text = result.toString()
        }
    }

    private fun findO(text: String): Int {
        val lst = text.split(" ")
        var res = 0
        val o = "o".toRegex()
        for (i in lst) {
            val count = o.findAll(i).count()
            if (i.contains("o") && count == 1) {
                res += 1
            }
        }
        return res
    }
}