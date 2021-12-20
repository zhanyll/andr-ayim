package com.example.andrayim

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2: Fragment(R.layout.fragment_2) {
    private lateinit var txt: AppCompatTextView
    private lateinit var btn: AppCompatButton
    private lateinit var listener: OnFragmentClick

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnFragmentClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txt = view.findViewById(R.id.txt)
        btn = view.findViewById(R.id.fragment2_btn)

        val text = arguments?.getString("key") ?: "defaultText"
        txt.text = "Fragment - $text"
        btn.text = "activity - $text"

        btn.setOnClickListener {
            listener.showActivity(text.toInt())
        }
    }
}