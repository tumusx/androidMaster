package com.github.retrofit.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.retrofit.data.CountryModel
import com.github.retrofit.data.CountryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CountryViewModel : ViewModel() {
    val messageError = MutableLiveData<String>()
    private val items = MutableLiveData<List<CountryModel>>()
    private val service = CountryService()

    val itemsLiveData: LiveData<List<CountryModel>>
        get() = items

    fun getCountry() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = service.pegarPaises()
            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    items.value = response.body()
                }
            } else {
                messageError.postValue(response.errorBody().toString())
            }

        }
    }
}