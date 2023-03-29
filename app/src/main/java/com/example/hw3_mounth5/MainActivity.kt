package com.example.hw3_mounth5


import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.example.hw3_mounth5.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var adapter = ImageAdapter(arrayListOf())
    var page = 1
    var name = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        binding.searchBtn.setOnClickListener {
          if (name != binding.keyWordEdit.text.toString()){
              name = binding.keyWordEdit.text.toString()
              adapter.cleanImage()
              page = 1
              requestImage()
          }else{
              page++
              requestImage()
          }

        }
        binding.searchBtn.setOnClickListener {
            name = binding.keyWordEdit.text.toString()
            page=1
            adapter.cleanImage()
requestImage()

        }
    }
    private fun requestImage(){

            ImageService().api.getImage(binding.keyWordEdit.text.toString(), page = page)
                .enqueue(object : Callback<PixaModel> {
                    override fun onResponse(call: Call<PixaModel>, response: Response<PixaModel>) {
                        if (response.isSuccessful) {
                            adapter.list = response.body()!!.hits
                            binding.recyclerView.adapter = adapter

                        }
                    }

                    override fun onFailure(call: Call<PixaModel>, t: Throwable) {
                        Log.e(TAG, "ololo:${t.message}")
                    }

                })
        }

    }

