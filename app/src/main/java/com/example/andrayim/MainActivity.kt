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
            val result = find(text)
            binding.wordKotlin.text = "number of Kotlin: ${result[0]}"
            binding.wordOf3.text = "number of 3char word: ${result[1]}"
        }
    }

    private fun find(text: String): List<Int> {
        val lst = text.split(" ", "\n", ",", ";", ":")
        val list = mutableListOf<Int>()

        var w3 = 0
        var count = 0
        for (i in lst) {
            if (i == "kotlin" || i == "Kotlin") {
                count++
            }
            if (i.length == 3) {
                w3++
            }
        }
        list.add(count)
        list.add(w3)
        return list
    }
}
