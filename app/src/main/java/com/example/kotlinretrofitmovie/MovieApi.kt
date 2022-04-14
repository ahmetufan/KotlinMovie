package com.example.kotlinretrofitmovie

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieApi {

    @GET("imdb/imdbSearchByName")
    fun getData(
        @Header("Authorization") apikey: String,
        @Query("query") query: String
    ): Call<List<ModelResult>>

}