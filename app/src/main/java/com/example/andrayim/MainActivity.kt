package com.example.andrayim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.andrayim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = SimpleAdapter{

            val intent = Intent(this, MainActivity2::class.java)
                .apply { putExtra("text", "activity of item - $it") }
            startActivity(intent)
        }

        val recycler = binding.recycler
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))

        val list = mutableListOf<String>()
        for (i in 0..30) {
            list.add("ITEM - $i")
        }

        adapter.setData(list)
    }
}