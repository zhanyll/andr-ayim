package com.example.andrayim

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.andrayim.databinding.Fragment1Binding

class Fragment1: Fragment(R.layout.fragment_1) {
    private lateinit var listener: OnButtonClick
    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = Fragment1Binding.bind(view)
//        val bundle = this.arguments
//        val text = bundle?.getString("fromFragment2")
//        binding.txt.text = text

        binding.btn.setOnClickListener { listener.onClickFirstFragment(binding.edit.text.toString()) }
    }

    fun setText(text: String) {
        binding.txt.text = text
    }
}