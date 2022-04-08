package com.example.a21bit

import Base
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a21bit.databinding.ActivityMainBinding
import com.example.tutu_ru.API.Common
import com.example.tutu_ru.API.NewsAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var newsAPI: NewsAPI = Common.newsAPI
        var adapter = NewsAdapter(mutableListOf())
        binding.rec.adapter = adapter
        binding.rec.setLayoutManager(LinearLayoutManager(this))

        newsAPI.get("apple","1ea67f1f3de54d68b3591faf77ac2d17").enqueue(object : Callback<Base> {
            override fun onResponse(call: Call<Base>, response: Response<Base>) {
//                println(response.body()?.articles)
                response.body()?.articles?.let { adapter.setdata(it) }
            }

            override fun onFailure(call: Call<Base>, t: Throwable) {
                println(t.message)
            }
        })
    }
}