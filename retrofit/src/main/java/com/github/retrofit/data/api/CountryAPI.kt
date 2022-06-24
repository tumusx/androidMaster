package com.github.retrofit.data.api

import com.github.retrofit.data.model.CountryModel
import retrofit2.http.GET

interface CountryAPI {

    @GET("all")
    suspend fun all() : retrofit2.Response<List<CountryModel>>
}