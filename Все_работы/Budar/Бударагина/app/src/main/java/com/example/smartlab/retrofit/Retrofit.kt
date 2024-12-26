package com.example.smartlab.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy

object Retrofit {
    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.39",3128))
    val httpClient = OkHttpClient.Builder().proxy(proxy).build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://rhiigoxpcojchvjkmfqh.supabase.co/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()

    val productInterface = retrofit.create(ProductInterface::class.java)
    val categoryInterface = retrofit.create(CategoryInterface::class.java)
    val actionsInterface = retrofit.create(ActionsInterface::class.java)
    val emailInterface = retrofit.create(PostEmailInterface::class.java)
}