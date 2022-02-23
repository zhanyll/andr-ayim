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
            val result = find(text)
            binding.wordKotlin.text = result.keys.toString()
            binding.wordOf3.text = result.values.toString()
        }
    }

    private fun find(text: String): MutableMap<Int, String> {
        val lst = arrayListOf("?", "!", ",", ";", ":", ".")
        var txt = text
        var count = 0
        for (i in text) { for (e in lst) if (i.toString().equals(e)){
            count++
        } }
        var txt2 = txt.replace("!", "*")
        txt = txt2.replace("?", "*")
        txt2 = txt.replace(".", "*")
        txt = txt2.replace(",", "*")
        txt2 = txt.replace(":", "*")
        txt = txt2.replace(";", "*")
        val list = mutableMapOf<Int, String>()
        list.put(count, txt)
        return list
    }
}