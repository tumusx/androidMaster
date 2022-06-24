package com.github.retrofit.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.retrofit.data.model.CountryModel
import com.github.retrofit.data.api.CountryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CountryViewModel : ViewModel() {
    private val messageError = MutableLiveData<String>()
    private val items = MutableLiveData<List<CountryModel>>()
    private val service = CountryService()

    val country: LiveData<List<CountryModel>>
        get() = items

    fun getCountry() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = service.pegarPaises()
            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    items.value = response.body()
                    Log.d("result service", response.body().toString())
                }
            } else {
                messageError.postValue(response.errorBody().toString())
            }
        }
    }
}