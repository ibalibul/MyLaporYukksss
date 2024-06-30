package com.example.model


import com.google.gson.annotations.SerializedName

data class ResponseDataUserItem(
    @SerializedName("Email")
    val email: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String
)