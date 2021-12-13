package com.example.andrayim

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.andrayim.databinding.Fragment2Binding

class Fragment2: Fragment(R.layout.fragment_2) {
    private var _binding: Fragment2Binding? = null
    private val binding get() = _binding!!
    private lateinit var listener: OnButtonClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = Fragment2Binding.bind(view)

//        val enteredText = binding.edit.text.toString()
//        val bundle = this.arguments
//        val text = bundle?.getString("fromFragment1")
//        binding.txt.text = text

        binding.btn.setOnClickListener { listener.onClickSecondFragment(binding.edit.text.toString()) }
    }

    fun setText(text: String) {
        binding.txt.text = text
    }
}