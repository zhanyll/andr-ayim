package com.example.andrayim

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.andrayim.databinding.FirstFragmentBinding

class FirstFragment: Fragment(R.layout.first_fragment) {
    private var _binding: FirstFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FirstFragmentBinding.bind(view)

        binding.signIn.setOnClickListener {

        }
    }

}