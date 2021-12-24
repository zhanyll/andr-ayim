package com.example.andrayim

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.andrayim.databinding.AuthorizationBinding

class Authorization: Fragment(R.layout.authorization) {
    private var _binding: AuthorizationBinding? = null
    private val binding get() = _binding!!
    private val preferences get() = Injector.preferences
    private lateinit var listener: OnClick
    private val login = preferences.getLogin("LOGIN_KEY")
    private val password = preferences.getPassword("PASSWORD_KEY")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = AuthorizationBinding.bind(view)

        binding.editEmail.addTextChangedListener(textWatcher)
        binding.editPassword.addTextChangedListener(textWatcher)

        binding.btn.setOnClickListener {
            if (binding.editEmail.text.toString() == login && binding.editPassword.text.toString() == password) {
                listener.onClick()
            } else {
                binding.passwordInputLayout.error = getString(R.string.error)
                Toast.makeText(activity, "wrong login or password!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val textWatcher = object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {}

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val email = binding.editEmail.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()
            binding.btn.isEnabled = email.isNotEmpty() && password.isNotEmpty()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}