package com.github.murillo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.murillo.R
import com.github.murillo.ui.utils.CareerType
import com.github.murillo.ui.utils.PersonType

class ParentAdapter(private var listCareers: MutableList<CareerType>) : RecyclerView.Adapter<ParentAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindView(typesCareers: CareerType){
            itemView.findViewById<TextView>(R.id.txtCargo).text = typesCareers.typeCareer
            val adapterChild = ChildAdapter(PersonType.listName())
            val adapterParent = itemView.findViewById<RecyclerView>(R.id.recyclerChild)
            adapterParent.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            adapterParent.adapter = adapterChild
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.container_item_parent, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindView(listCareers[position])
    }

    override fun getItemCount(): Int {
        return listCareers.size
    }

    fun onChange(itemList: MutableList<CareerType>){
        listCareers = itemList
        notifyDataSetChanged()
    }
}