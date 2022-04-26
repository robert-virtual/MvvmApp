package com.example.mvvmapp.api

import com.example.mvvmapp.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.QUOTES_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val quotesApi:QuotesApi by lazy {
        retrofit.create(QuotesApi::class.java)
    }
}