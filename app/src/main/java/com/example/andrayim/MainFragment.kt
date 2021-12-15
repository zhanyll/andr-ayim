package com.example.andrayim

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.andrayim.databinding.MainFragmentBinding

class MainFragment: Fragment(R.layout.main_fragment) {
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: OnClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = MainFragmentBinding.bind(view)
        binding.toolbar.inflateMenu(R.menu.menu)
        binding.toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.aboutMenu) {
                Log.e("TAG", "click")
                listener.onClickMenu()
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