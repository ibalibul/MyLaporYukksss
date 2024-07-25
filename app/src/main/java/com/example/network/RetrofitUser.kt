package com.example.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUser {

    const val BASE_URL = "https://b7cb-182-0-229-88.ngrok-free.app/"

    private val logging : HttpLoggingInterceptor
        get(){
            val httpLoginInterceotor = HttpLoggingInterceptor()
            return httpLoginInterceotor.apply {
                httpLoginInterceotor.level = HttpLoggingInterceptor.Level.BODY
            }
        }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
    val instance : RestfulApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        retrofit.create(RestfulApi::class.java)
    }


}