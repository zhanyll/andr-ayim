package com.example.andrayim

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.andrayim.databinding.AuthorizationBinding

class Authorization: Fragment(R.layout.authorization) {
    private var _binding: AuthorizationBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: OnClick
    private val login = "zhanyll@gmail.com"
    private val password = "Zhanyl2000"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = AuthorizationBinding.bind(view)

        binding.btn.setOnClickListener {
            if (binding.editEmail.text.toString() == login && binding.editPassword.text.toString() == password) {
                listener.onClick()
            } else {
                Toast.makeText(activity, "wrong login or password!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}