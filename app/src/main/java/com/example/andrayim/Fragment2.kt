package com.example.andrayim

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.andrayim.databinding.Fragment1Binding
import com.example.andrayim.databinding.Fragment2Binding

class Fragment2: Fragment(R.layout.fragment_2) {
    private var _binding: Fragment2Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = Fragment2Binding.bind(view)
    }

    fun setImage(image: String) {
        when (image) {
            "ocean" -> binding.image.setImageResource(R.drawable.ocean)
            "forest" -> binding.image.setImageResource(R.drawable.forest)
            "mountain" -> binding.image.setImageResource(R.drawable.mountain)
        }
    }
}