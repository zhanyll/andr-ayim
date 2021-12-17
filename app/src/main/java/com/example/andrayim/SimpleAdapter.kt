package com.example.andrayim

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

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

        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View,
    private val click: (pos: Int) -> Unit): RecyclerView.ViewHolder(itemView) {
        fun bind(item: String, position: Int) {
            val txt = itemView.findViewById<AppCompatTextView>(R.id.itemText)
            txt.text = item

            val img = itemView.findViewById<AppCompatImageView>(R.id.itemImage)
            if (position % 2 == 1) {
                Glide
                    .with(itemView)
                    .load("https://cdn0.iconfinder.com/data/icons/health-icons-rounded/110/Medicine-2-512.png")
                    .into(img)
            } else {
                Glide
                    .with(itemView)
                    .load("https://cdn-icons-png.flaticon.com/512/172/172835.png")
                    .into(img)
            }

            itemView.setOnClickListener{
                click.invoke(adapterPosition)
            }
        }
    }
}