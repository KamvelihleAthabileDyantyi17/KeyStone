package com.example.keystone

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // 10.0.2.2 routes directly to your local computer's host!
    private const val BASE_URL = "http://10.0.2.2:5000/"

    val apiService: KeystoneApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KeystoneApiService::class.java)
    }
}