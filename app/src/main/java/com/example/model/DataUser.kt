package com.example.model

import java.io.Serializable

data class DataUser(
    val name : String,
    val email : String,
    val password: String,
    val notlp: Long
): Serializable
