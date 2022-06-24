package com.github.retrofit.data.api

import com.github.retrofit.data.model.CountryModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountryService {
    private val api: CountryAPI = Retrofit.Builder()
        .baseUrl("https://restcountries.com/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CountryAPI::class.java)

    suspend fun pegarPaises() : retrofit2.Response<List<CountryModel>> = api.all()
}