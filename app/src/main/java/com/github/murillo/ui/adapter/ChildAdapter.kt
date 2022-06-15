package com.github.murillo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.murillo.R
import com.github.murillo.ui.utils.PersonType

class ChildAdapter(private val listName: MutableList<PersonType>) : RecyclerView.Adapter<ChildAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(itemPerson: PersonType) {
            val textPersonName = itemView.findViewById<TextView>(R.id.textName)
            textPersonName.text = itemPerson.nome
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewInflater = LayoutInflater.from(parent.context).inflate(R.layout.container_child_item, parent, false)
        return MyViewHolder(viewInflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(listName[position])
    }

    override fun getItemCount(): Int {
        return listName.size
    }


}