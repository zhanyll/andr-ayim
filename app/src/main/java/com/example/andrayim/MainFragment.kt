package com.example.andrayim

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainFragment: Fragment(R.layout.main_fragment) {
    private val dbInstance get() = Injector.database
    private lateinit var listener: Clicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Clicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MyAdapter{ listener.onClick(it.toLong()) }
        val list = dbInstance.employeeDao().getAll()

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val btn = view.findViewById<AppCompatButton>(R.id.addBtn)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))
        adapter.setData(list)

        btn.setOnClickListener {
            listener.onAdd()
        }
    }
}