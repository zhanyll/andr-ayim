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

        binding.btn.setOnClickListener {
            if (binding.editEmail.text.toString() == login && binding.editPassword.text.toString() == password) {
                listener.onClick()
            } else {
                binding.passwordInputLayout.error = getString(R.string.error)
                Toast.makeText(activity, "wrong login or password!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}