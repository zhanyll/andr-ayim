package com.example.andrayim

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.andrayim.databinding.Fragment1Binding

class Fragment1: Fragment(R.layout.fragment_1) {
    private lateinit var listener: ChangeImage
    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as ChangeImage
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = Fragment1Binding.bind(view)

        binding.btn1.setOnClickListener { listener.onClick("ocean") }
        binding.btn2.setOnClickListener { listener.onClick("forest") }
        binding.btn3.setOnClickListener { listener.onClick("mountain") }
    }


}