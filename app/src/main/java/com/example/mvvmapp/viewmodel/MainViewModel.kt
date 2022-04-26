package com.example.mvvmapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmapp.api.RetrofitInstance
import com.example.mvvmapp.model.Quote
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    val randomQuote:MutableLiveData<Quote> = MutableLiveData()
    val quotes:MutableLiveData<List<Quote>> = MutableLiveData()
    val error:MutableLiveData<String> = MutableLiveData()

    fun getAllQuotes(){
        viewModelScope.launch {
            try {
                quotes.value = RetrofitInstance.quotesApi.getAllQuotes()
            }catch (e:Exception){
                error.value = e.message
            }
        }
    }

    fun getRandomQuote(){
        viewModelScope.launch {
            try {
                randomQuote.value = RetrofitInstance.quotesApi.getRandomQuote()
            }catch (e:Exception){
               error.value = e.message
            }
        }
    }
}