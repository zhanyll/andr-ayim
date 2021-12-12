package com.example.andrayim

import android.content.res.Configuration
import android.net.LinkAddress
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andrayim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ChangeImage {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_1, Fragment1())
            .addToBackStack(null)
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_2, Fragment2())
            .addToBackStack(null)
            .commit()
    }

    override fun onClick(image: String) {
        val fragment2 = supportFragmentManager.findFragmentById(R.id.fragment_container_2) as Fragment2
        fragment2.setImage(image)
    }
}