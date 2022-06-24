package com.github.mvvm_search_cep.data

import java.io.Serializable

data class CepModel(
    val bairro: String,
    val cep: String,
    val complemento: String,
    val ddd: String,
    val gia: String,
    val ibge: String,
    val localidade: String,
    val logradouro: String,
    val siafi: String,
    val uf: String
): Serializable