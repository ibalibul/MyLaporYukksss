package com.example.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseDataFilmItem(
    @SerializedName("desription")
    val desription: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: String,
    @SerializedName("name")
    val name: String
):Serializable