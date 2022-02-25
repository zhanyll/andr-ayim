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
        val episodeFragment = EpisodeFragment()
        val bundle = Bundle()
        bundle.putLong("id", id)
        episodeFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, episodeFragment)
            .addToBackStack(null)
            .commit()
    }
}