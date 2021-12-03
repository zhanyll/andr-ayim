package com.example.andrayim

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.andrayim.databinding.Fragment1Binding

class Fragment1: Fragment(R.layout.fragment_1) {
    private lateinit var listener: OnFragmentClick
    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listener = context as OnFragmentClick

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = Fragment1Binding.bind(view)

        val adapter = Adapter1{
            listener.onClick(it)
        }

        binding.apply {
            val recycler = binding.recycler
            recycler.adapter = adapter
            recycler.layoutManager = LinearLayoutManager(activity)
            recycler.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))
        }

//        val recycler = view?.findViewById<RecyclerView>(R.id.recycler)


        val list = mutableListOf<String>()
        for (i in 0..30) {
            list.add("ITEM - $i")
        }

        adapter.setData(list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}