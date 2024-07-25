package com.example.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseDataPengaduanItem(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("deskripsi")
    val deskripsi: String,
    @SerializedName("foto")
    val foto: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("Judul")
    val judul: String,
    @SerializedName("lokasi")
    val lokasi: String,
    @SerializedName("notlp")
    val notlp: Long,
    @SerializedName("tanggal")
    val tanggal: String,
    @SerializedName("updatedAt")
    val updatedAt: String
) : Serializable