package com.example.andrayim

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.andrayim.databinding.RegistrationFragmentBinding

class RegistrationFragment: Fragment(R.layout.registration_fragment) {
    private var _binding: RegistrationFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: OnClick
    private val preferences get() = Injector.preferences

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = RegistrationFragmentBinding.bind(view)

        binding.btn.setOnClickListener {
            preferences.saveLogin(binding.editEmail.text.toString())
            preferences.savePassword(binding.editPassword.text.toString())

            listener.onClick()
        }
    }
}