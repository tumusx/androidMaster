package com.github.reyclerview.ui.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.reyclerview.R
import com.github.reyclerview.ui.enum.SortItemsType

class SortItemsAdapter(var listItems: List<SortItemsType>) :
    RecyclerView.Adapter<SortItemsAdapter.MyViewHolder>() {


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(items: SortItemsType) {
            itemView.findViewById<TextView>(R.id.textView).text = items.numbers.toString()
            itemView.findViewById<TextView>(R.id.txtOrdEr).text = items.txtOrder
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.container_items_numbers, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    fun onChangeList(items: MutableList<SortItemsType>) {
        listItems = items
        notifyDataSetChanged()
    }
}