package com.example.andrayim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnFragmentClick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, Fragment1())
            .commit()
    }

    override fun onClick(enteredText: Int) {
        val fragment2 = Fragment2()
        val bundle = Bundle()
        bundle.putString("key", enteredText.toString())
        fragment2.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment2)
            .addToBackStack(null)
            .commit()
    }

    override fun showActivity(enteredText: Int) {
        val intent = Intent("openActivity")
        intent.putExtra("key", enteredText.toString())
        startActivity(intent)
    }
}