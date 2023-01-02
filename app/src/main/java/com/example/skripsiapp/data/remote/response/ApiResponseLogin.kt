package com.example.skripsiapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class ApiResponseLogin(

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("data")
    val data: LoginResponse
)

data class LoginResponse(
    val id : String,
    val nama: String
)
