package com.example.mvvmapp.api

import com.example.mvvmapp.model.Quote
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {
    @GET("quotes/random")
    suspend fun getRandomQuote():Quote
}