package com.example.andrayim

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.andrayim.databinding.AboutFragmentBinding

class AboutFragment: Fragment(R.layout.about_fragment) {
    private lateinit var listener: OnClick
    private var _binding: AboutFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = AboutFragmentBinding.bind(view)
        binding.toolbar.inflateMenu(R.menu.menu_about)
        binding.toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.backMenu) {
                listener.onClick()
            } else {
                Toast.makeText(activity, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}