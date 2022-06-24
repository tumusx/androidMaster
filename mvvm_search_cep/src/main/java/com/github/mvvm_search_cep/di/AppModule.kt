package com.github.mvvm_search_cep.di

import com.github.mvvm_search_cep.data.SearchCepRepository
import com.github.mvvm_search_cep.view.SearchCepViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module



val viewModelModule = module{
    viewModel { (cepRepository: SearchCepRepository)-> SearchCepViewModel(cepRepository)}
}