package com.github.mvvm_search_cep.data

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object SearchCepRepository {
    val retrofitBuilder = Retrofit.Builder()
        .baseUrl("https://viacep.com.br/ws/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val cepRepository: SearchCepService = retrofitBuilder.create(SearchCepService::class.java)

}
