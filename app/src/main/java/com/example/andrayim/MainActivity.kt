package com.example.andrayim

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        when (resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> setContentView(R.layout.activity_main)
            Configuration.ORIENTATION_LANDSCAPE -> setContentView(R.layout.activity_main_horizontal)
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_1, Fragment1())
            .addToBackStack(null)
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_2, Fragment2())
            .addToBackStack(null)
            .commit()
    }
}