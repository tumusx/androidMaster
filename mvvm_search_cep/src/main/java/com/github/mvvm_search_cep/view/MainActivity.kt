package com.github.mvvm_search_cep.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.github.mvvm_search_cep.data.SearchCepRepository
import com.github.mvvm_search_cep.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {
    private val searchCepViewModel: SearchCepViewModel by viewModel {
        parametersOf(SearchCepRepository)
    }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = searchCepViewModel
        getCep()
    }

     private fun getCep(){
        binding.btnSearchCEP.setOnClickListener {
            searchCepViewModel.getCep()
        }
    }
}