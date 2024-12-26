package com.example.smartlab

import okhttp3.Interceptor
import okhttp3.Response

class SupabaseInterceptor(
    private val apiKey: String,
    private val jwtToken: String? = null
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("apikey", apiKey)
        jwtToken?.let {
            request.addHeader("Authorization", "Bearer $it")
        }
        return chain.proceed(request.build())
    }
}