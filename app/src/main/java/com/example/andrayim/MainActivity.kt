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
        val employee_fragment = EmployeeFragment()
        val bundle = Bundle()
        bundle.putLong("id", id)
        employee_fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, employee_fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onAdd() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, AddEmployeeFragment())
            .commit()
    }

    override fun onEdit(id: Long) {
        val editEmployeeFragment = EditEmployeeFragment()
        val bundle = Bundle()
        bundle.putLong("id", id)
        editEmployeeFragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, editEmployeeFragment)
            .commit()
    }
}