package com.example.smartlab.retrofit

import com.example.smartlab.allData.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ProductInterface {
    @Headers("apikey:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InJoaWlnb3hwY29qY2h2amttZnFoIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzUwMTk4ODAsImV4cCI6MjA1MDU5NTg4MH0.hzKLY_jC2Pap-Pb1w8tXDZKqjsubmBm0zTfnfLr8S8Q")
    @GET("rest/v1/products?select")
    fun getProsucts(): Call<List<Products>>
}