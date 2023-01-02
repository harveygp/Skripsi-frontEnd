package com.example.skripsiapp.data.remote.response

data class DataResponse(
    val matkul: List<Matkul>,
    val nama: String
)

data class Matkul(
    val jurusan: String,
    val nilai: Double = 0.0
)
