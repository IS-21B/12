package com.example.smartlab.retrofit

import com.example.smartlab.allData.SignUpRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface PostEmailInterface {
    @Headers("apikey:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InJoaWlnb3hwY29qY2h2amttZnFoIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzUwMTk4ODAsImV4cCI6MjA1MDU5NTg4MH0.hzKLY_jC2Pap-Pb1w8tXDZKqjsubmBm0zTfnfLr8S8Q")
    @POST("auth/v1/signup") // Это эндпоинт для регистрации пользователя
    suspend fun signUp(@Body signUpRequest: SignUpRequest): Response<Map<String, Any>>
}