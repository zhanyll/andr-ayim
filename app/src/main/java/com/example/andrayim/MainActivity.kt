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
            binding.word.text = result?.key ?: ""
            binding.max.text = (result?.value ?: 0).toString()
        }
    }

    private fun findO(text: String): Map.Entry<String, Int>? {
        val lst = text.split(" ", "\n")
        val char = "a".toRegex()
        val list = mutableMapOf<String, Int>()
        for (i in lst) {
            val count = char.findAll(i).count()
            list.put(i, count)
        }
        val max = list.maxByOrNull { p -> p.value }
        return max
    }
}

// классная классификация яркая дерзкий
//лёгкий смелая