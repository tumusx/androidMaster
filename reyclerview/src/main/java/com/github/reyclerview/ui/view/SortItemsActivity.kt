package com.github.reyclerview.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.reyclerview.databinding.ActivitySortItemsBinding
import com.github.reyclerview.ui.adapter.SortItemsAdapter
import com.github.reyclerview.ui.enum.SortItemsType
import java.util.*

class SortItemsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySortItemsBinding
    private lateinit var adapterView: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySortItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onOrderList()
    }

    private fun onConfigureAdapter(listOrder: List<SortItemsType>) {
        binding.recyclerView.apply {
            adapterView = SortItemsAdapter(listOrder)
            adapter = adapterView
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun onOrderList(){
        val listOrder : MutableList<SortItemsType> = SortItemsType.getListNumber()
        binding.button.setOnClickListener {
            val list = listOrder.sortedBy { it.numbers }
            onConfigureAdapter(list) }
        binding.button2.setOnClickListener {
            onConfigureAdapter(listOrder.sortedByDescending { it.numbers })}
    }
}