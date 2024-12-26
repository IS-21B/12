package com.example.smartlab

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy

object RetrofitHelper {
    fun getClient(
        supabaseAnonKey: String,
        supabaseJwtToken: String? = null
    ): Retrofit {
        val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.39", 	3128))
        val client = OkHttpClient.Builder()
            .addInterceptor(SupabaseInterceptor(supabaseAnonKey, supabaseJwtToken))
            .proxy(proxy)
            .build()
        return Retrofit.Builder()
            .baseUrl("https://txrxukqjrsccpjatknmn.supabase.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}