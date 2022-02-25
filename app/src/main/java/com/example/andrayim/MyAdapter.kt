package com.example.andrayim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.schedulers.Schedulers
import java.util.*

class MyAdapter(private val click: (episode: Episode) -> Unit): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    private var list: List<Episode> = mutableListOf()
//    private var list = api.getEpisodes()

    fun setData(list: List<Episode>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(itemView, click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View,
                     private val click: (episode: Episode) -> Unit): RecyclerView.ViewHolder(itemView) {
        fun bind(item: Episode) {
            val txt = itemView.findViewById<AppCompatTextView>(R.id.item_txt)
            txt.text = item.title

            itemView.setOnClickListener {
                click.invoke(item)
            }
        }
    }
}