package com.example.network

import com.example.model.DataFilm
import com.example.model.PostResponseFilm
import com.example.model.PostResponseFilmItem
import com.example.model.ResponseDataFilmItem
import com.example.model.ResponseDataUserItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RestfulApi {

    @GET("user")
    fun getAllUser() :Call<List<ResponseDataUserItem>>

    @GET("film")
    fun getAllDataFilm() : Call<List<ResponseDataFilmItem>>

    @POST("film")
    fun addDataFilm(@Body request : DataFilm) : Call<PostResponseFilm>

    
}