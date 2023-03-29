package com.example.hw3_mounth5


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface PixaApi {
@GET("/api/")
fun  getImage(
    @Query("q") keyWord:String,
    @Query("page") page:Int = 1,
    @Query("per_page") per_page:Int = 3,
    @Query("key") key: String = "34791407-ec97a4b4262dab6aee9e8aa5c"

): Call<PixaModel>




}