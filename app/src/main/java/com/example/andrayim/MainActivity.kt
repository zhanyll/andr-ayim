package com.example.andrayim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andrayim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClick {
    private lateinit var binding: ActivityMainBinding
    private val preferences get() = Injector.preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val myPrefs = this.preferences
        val login = preferences.getLogin("LOGIN_KEY")
        if (login.isEmpty()) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, RegistrationFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, Authorization())
                .commit()
        }
    }

    override fun onClick() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MainFragment())
            .commit()
    }

    override fun onClickMenu() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, AboutFragment())
            .addToBackStack(null)
            .commit()
    }
}