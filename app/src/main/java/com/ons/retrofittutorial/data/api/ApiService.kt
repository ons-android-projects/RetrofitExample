package com.ons.retrofittutorial.data.api

import com.ons.retrofittutorial.data.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    fun getAllPosts(): Call<List<Post>>

}