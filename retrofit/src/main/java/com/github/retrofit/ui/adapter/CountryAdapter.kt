package com.github.retrofit.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.retrofit.R
import com.github.retrofit.data.CountryModel

class CountryAdapter(private val items: MutableList<CountryModel>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val countryName = view.findViewById<TextView>(R.id.txtCountry)

        fun bind(country: CountryModel) {
            countryName.text = country.name
        }
    }

    fun update(countries: List<CountryModel>) {
        items.clear()
        items.addAll(countries)
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.container_country_items, parent, false)
    )

}