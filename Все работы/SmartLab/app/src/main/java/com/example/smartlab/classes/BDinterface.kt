package com.example.smartlab.classes


import com.example.smartlab.data.Actions
import com.example.smartlab.data.Categories
import com.example.smartlab.data.Products
import com.example.smartlab.data.SignUpRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ProductInterface {
    @Headers("apikey:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InR6cWFhamRrcmF6dWJna3JzYW93Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzQ2Mjc3MTQsImV4cCI6MjA1MDIwMzcxNH0.HGywS1RnYta73ORLJ21VnccU4EaDGi9drecyWsF8rVY")
    @GET("rest/v1/products?select")
    fun getProsucts(): Call<List<Products>>
}
interface CategoryInterface {
    @Headers("apikey:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InR6cWFhamRrcmF6dWJna3JzYW93Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzQ2Mjc3MTQsImV4cCI6MjA1MDIwMzcxNH0.HGywS1RnYta73ORLJ21VnccU4EaDGi9drecyWsF8rVY")
    @GET("/rest/v1/categories?select")
    fun getCategory(): Call<List<Categories>>
}
interface ActionsInterface {
    @Headers("apikey:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InR6cWFhamRrcmF6dWJna3JzYW93Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzQ2Mjc3MTQsImV4cCI6MjA1MDIwMzcxNH0.HGywS1RnYta73ORLJ21VnccU4EaDGi9drecyWsF8rVY")
    @GET("/rest/v1/actions?select")
    fun getActions(): Call<List<Actions>>
}
interface PostEmailInterface{
    @Headers("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InR6cWFhamRrcmF6dWJna3JzYW93Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzQ2Mjc3MTQsImV4cCI6MjA1MDIwMzcxNH0.HGywS1RnYta73ORLJ21VnccU4EaDGi9drecyWsF8rVY")
    @POST("auth/v1/signup") // Это эндпоинт для регистрации пользователя
    suspend fun signUp(@Body signUpRequest: SignUpRequest): Response<Map<String, Any>>
}