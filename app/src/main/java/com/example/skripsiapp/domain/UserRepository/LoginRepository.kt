package com.example.skripsiapp.domain.UserRepository

import com.example.skripsiapp.data.remote.response.ApiResponseLogin
import com.example.skripsiapp.utils.Result
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    suspend fun getUserLoginIpa(nama : String) : Flow<Result<ApiResponseLogin>>

    suspend fun getUserLoginIps(nama : String) : Flow<Result<ApiResponseLogin>>


}