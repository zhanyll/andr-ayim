package com.example.andrayim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andrayim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Clicked {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, MainFragment())
            .commit()
    }

    override fun onMain() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MainFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onClick(id: Long) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, EmployeeFragment())
            .addToBackStack(null)
            .commit()
    }

    override fun onAdd() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, AddEmployeeFragment())
            .commit()
    }

    override fun onEdit() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, EditEmployeeFragment())
            .commit()
    }
}