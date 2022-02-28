package com.example.andrayim

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.andrayim.database.Employee
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainFragment: Fragment(R.layout.main_fragment) {
    private val dbInstance get() = Injector.database
    private lateinit var listener: Clicked
    private lateinit var adapter: MyAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Clicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MyAdapter( click = { listener.onClick(it.id!!) }, deleteClick = { id: Long, position: Int -> onDeleteClick(id, position)})
        val list = dbInstance.employeeDao().getAll()

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val btn = view.findViewById<AppCompatButton>(R.id.addBtn)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))
        dbInstance.employeeDao().getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { adapter.setData(it) }
            .subscribe()

        btn.setOnClickListener {
            listener.onAdd()
        }
    }

    private fun onDeleteClick(id: Long, position: Int) {
        dbInstance.employeeDao().getById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { e ->
                showAlert(e, position)
            }
            .subscribe()
    }

    private fun showAlert(e: Employee, position: Int) {
        val builder = AlertDialog.Builder(requireContext())
        builder.apply {
            setTitle("delete this item?")
            setPositiveButton("yes",
                DialogInterface.OnClickListener { dialog, id ->
                    dbInstance.employeeDao().delete(e)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()
                    adapter.deleteItem(position)
                })
            setNegativeButton("no",
                DialogInterface.OnClickListener { dialog, id ->
                    Toast.makeText(context, "canceled", Toast.LENGTH_SHORT).show()
                })
        }
        builder.create()
        builder.show()
    }
}