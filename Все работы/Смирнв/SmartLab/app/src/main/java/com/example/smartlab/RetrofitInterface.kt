package com.example.smartlab

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface RetrofitInterface {
    @GET("actions")
    fun getActions(
        @Header("apikey") apiKey: String,
        @Header("Authorization") authHeader: String
    ) : Call<Array<Action>>
}