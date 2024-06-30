package com.example.adapter

import java.io.Serializable

data class ListBerita(
    val judulBerita : String,
    val lokasiBerita : String,
    val descriptiBerita : String,
    val image :Int
): Serializable
