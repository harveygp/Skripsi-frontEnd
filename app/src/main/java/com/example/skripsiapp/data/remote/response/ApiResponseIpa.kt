package com.example.skripsiapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class ApiResponseIpa(

    @field:SerializedName("success")
    val success: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("data")
    val data: DataResponse
)

