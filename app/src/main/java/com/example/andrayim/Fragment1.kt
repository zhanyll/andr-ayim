package com.example.andrayim

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment1: Fragment(R.layout.fragment_1) {
    private lateinit var listener: OnFragmentClick

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
        val adapter = Adapter1{
            listener.onClick(it)
        }

        val recycler = view?.findViewById<RecyclerView>(R.id.recycler) // view указана как не nullable, поэтому nullsafty вызов тут лишний
        recycler?.adapter = adapter // тогда и в recycler'е не нужен будет nullsafty вызов
        recycler?.layoutManager = LinearLayoutManager(activity)
        recycler?.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))

        val list = mutableListOf<String>()
        for (i in 0..30) {
            list.add("ITEM - $i")
        }

        adapter.setData(list)
    }
}
