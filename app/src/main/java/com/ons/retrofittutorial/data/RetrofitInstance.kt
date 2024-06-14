package com.ons.retrofittutorial.data

import com.ons.retrofittutorial.data.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    private fun getRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiServiceInstance(): ApiService{
        return getRetrofitInstance().create(ApiService::class.java)
    }

}