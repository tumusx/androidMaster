package com.github.mvvm_search_cep.data

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface SearchCepService {

    @GET("{CEP}/json")
     fun onGetCEP(@Path("CEP") numberCEP: String): Call<CepModel>
}