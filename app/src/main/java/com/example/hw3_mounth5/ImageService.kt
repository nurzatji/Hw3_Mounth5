package com.example.hw3_mounth5

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ImageService {

 private   var retrofit = Retrofit.Builder().baseUrl("https://pixabay.com").addConverterFactory(
        GsonConverterFactory.create()).build()
    var api = retrofit.create(PixaApi::class.java)
}