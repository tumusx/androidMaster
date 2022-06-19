package com.github.retrofit.data

import okhttp3.Response
import retrofit2.http.GET

interface CountryAPI {

    @GET("all")
    suspend fun all() : retrofit2.Response<List<CountryModel>>
}