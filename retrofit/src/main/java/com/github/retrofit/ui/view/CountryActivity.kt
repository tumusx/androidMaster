package com.github.retrofit.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.retrofit.databinding.ActivityCountryBinding
import com.github.retrofit.ui.adapter.CountryAdapter
import com.github.retrofit.ui.viewModel.CountryViewModel

class CountryActivity : AppCompatActivity() {
    private lateinit var viewModel: CountryViewModel
    private var myAdapter = CountryAdapter(mutableListOf())
    private lateinit var binding: ActivityCountryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(CountryViewModel::class.java)
        setContentView(binding.root)
        onConfigureUI()
        viewModel.getCountry()
    }

    private fun onConfigureUI() {
        binding.recyclerView.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(this@CountryActivity)
        }

        viewModel.country.observe(this@CountryActivity) { countries ->
            myAdapter.update(countries.sortedByDescending { it.name })
        }
    }
}