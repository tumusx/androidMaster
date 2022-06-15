package com.github.murillo.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import com.github.murillo.R
import com.github.murillo.ui.adapter.ParentAdapter
import com.github.murillo.ui.utils.CareerType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onConfigureAdapter()
    }

    private fun onConfigureAdapter(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerMain)
        val parentAdapter = ParentAdapter(CareerType.getCareerType())
        recyclerView.apply {
            adapter = parentAdapter
            layoutManager = LinearLayoutManager(context, VERTICAL, false)
            parentAdapter.onChange(CareerType.getCareerType())
        }
    }
}