package com.example.network

import com.example.model.DataFilm
import com.example.model.DataPengaduan
import com.example.model.DataUser
import com.example.model.PostResponseFilm
import com.example.model.ResponseDataFilmItem
import com.example.model.ResponseDataPengaduanItem
import com.example.model.ResponseDataUserrItem
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RestfulApi {

    @GET("users")
    fun getAllUser() :Call<List<ResponseDataUserrItem>>

    @POST("users")
    fun addPostUser(@Body request: DataUser) : Call<ResponseDataUserrItem>

    @GET("film")
    fun getAllDataFilm() : Call<List<ResponseDataFilmItem>>

    @GET("pengaduan")
    fun getallPengaduan() : Call<List<ResponseDataPengaduanItem>>

    @POST("pengaduan")
    fun addPostPengaduan(@Body request : DataPengaduan) : Call<ResponseDataPengaduanItem>



    
}