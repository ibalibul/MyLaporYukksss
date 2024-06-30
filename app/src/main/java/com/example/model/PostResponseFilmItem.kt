package com.example.model


import com.google.gson.annotations.SerializedName

data class PostResponseFilmItem(
    @SerializedName("desription")
    val desription: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: String,
    @SerializedName("Name")
    val name: String
)