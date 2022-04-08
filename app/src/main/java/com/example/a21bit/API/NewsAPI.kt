package com.example.tutu_ru.API

import Base
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET("everything")
    fun get(@Query("q") q : String, @Query("apiKey") apikey : String): Call<Base>
}