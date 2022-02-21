package com.example.andrayim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.andrayim.database.Employee

class MyAdapter(private val click: (employee: Employee) -> Unit,
                private val deleteClick: (id: Long, position: Int) -> Unit): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private val dbInstance get() = Injector.database
    private var list = dbInstance.employeeDao().getAll()

    fun setData(list: List<Employee>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        list = list.toMutableList().apply { removeAt(position) }
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, list.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(itemView, click, deleteClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View,
                     private val click: (employee:Employee) -> Unit,
                     private val deleteClick: (id: Long, position: Int) -> Unit): RecyclerView.ViewHolder(itemView) {
        fun bind(item: Employee) {
            val txt = itemView.findViewById<AppCompatTextView>(R.id.item_txt)
            val btnDelete = itemView.findViewById<AppCompatImageButton>(R.id.btnDelete)
            txt.text = item.name

            itemView.setOnClickListener {
                click.invoke(item)
            }

            btnDelete.setOnClickListener{
                deleteClick.invoke(item.id?: 1, adapterPosition)
            }
        }
    }
}