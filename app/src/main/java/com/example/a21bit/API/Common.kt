package com.example.tutu_ru.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Common {
    private val url = "https://newsapi.org/v2/"
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val newsAPI : NewsAPI = retrofit.create(NewsAPI::class.java)
}