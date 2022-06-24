package com.github.mvvm_search_cep.view

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.mvvm_search_cep.data.CepModel
import com.github.mvvm_search_cep.data.SearchCepRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
class SearchCepViewModel(private val searchRepository: SearchCepRepository): ViewModel() {
    val getCEP = ObservableField<String>()
    val resultCode = MutableLiveData<Boolean>()
    val setText = ObservableField<String>()

     fun getCep(){
         Log.d("CEPA", getCEP.get().toString())
         viewModelScope.launch(Dispatchers.IO){
        val onRepository = searchRepository.cepRepository.onGetCEP(getCEP.get().toString())
        onRepository.enqueue(object: retrofit2.Callback<CepModel>{
            override fun onResponse(call: retrofit2.Call<CepModel>, response: Response<CepModel>) {
                viewModelScope.launch(Dispatchers.Main){
                resultCode.postValue(true)
                    setText.set(response.body().toString())
                    Log.d("TOP", response.body().toString())
                }
            }

            override fun onFailure(call: retrofit2.Call<CepModel>, t: Throwable) {
                resultCode.postValue(false)
            }})
        }
    }
}