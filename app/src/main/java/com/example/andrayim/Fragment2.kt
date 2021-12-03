package com.example.andrayim

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.example.andrayim.databinding.Fragment2Binding

class Fragment2: Fragment(R.layout.fragment_2) {
    private lateinit var txt: AppCompatTextView
    private var _binding: Fragment2Binding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = Fragment2Binding.bind(view)
        binding.apply {
            val txt = binding.txt
            val text = arguments?.getString("key") ?: "defaultText"
            txt.text = "Fragment - $text"
        }

//        txt = view.findViewById(R.id.txt)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}