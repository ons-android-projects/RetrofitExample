package com.ons.retrofittutorial

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ons.retrofittutorial.data.Post
import com.ons.retrofittutorial.data.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var getPostButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPostButton = findViewById(R.id.getPostBtn)

        getPostButton.setOnClickListener {
            getPosts()
        }

    }

    private fun getPosts(){

        val apiService = RetrofitInstance.getApiServiceInstance()
        val call = apiService.getAllPosts()

        call.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val responseBody = response.body()
                responseBody?.let {posts ->
                    posts.forEach { post ->
                        Log.d("POST", "onResponse: ${post.title}")
                    }
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e("POST", "onResponse: ${t.message}")
            }
        })

    }

}