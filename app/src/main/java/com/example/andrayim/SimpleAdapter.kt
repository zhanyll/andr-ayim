package com.example.andrayim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class SimpleAdapter(private val click: (pos: Int) -> Unit): RecyclerView.Adapter<SimpleAdapter.MyViewHolder>() {
    private var list = listOf<String>()

    fun setData(list: List<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return MyViewHolder(itemView, click)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class MyViewHolder(itemView: View,
    private val click: (pos: Int) -> Unit): RecyclerView.ViewHolder(itemView) {
        fun bind(item: String) {
            val txt = itemView.findViewById<AppCompatTextView>(R.id.itemText)
            txt.text = item
            itemView.setOnClickListener{
                click.invoke(adapterPosition)
            }
        }
    }
}