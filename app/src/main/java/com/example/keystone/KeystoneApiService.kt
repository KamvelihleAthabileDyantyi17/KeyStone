package com.example.keystone
import retrofit2.Call
import retrofit2.http.GET

interface KeystoneApiService {
    // This connects to http://10.0.2.2:5000/api/properties
    @GET("api/properties")
    fun getProperties(): Call<List<PropertyModel>>
}