package com.example.skripsiapp.domain.UserRepository

import com.example.skripsiapp.data.remote.response.ApiResponseIpa
import com.example.skripsiapp.data.remote.response.ApiResponseIps
import kotlinx.coroutines.flow.Flow
import com.example.skripsiapp.utils.Result

interface UserRepository {

    suspend fun getUserIpsUpnvj(nama : String) : Flow<Result<ApiResponseIps>>

    suspend fun getUserIpsUnj(nama : String) : Flow<Result<ApiResponseIps>>

    suspend fun getUserIpsUinj(nama : String) : Flow<Result<ApiResponseIps>>

    suspend fun getUserIpaUpnvj(nama : String) : Flow<Result<ApiResponseIpa>>

    suspend fun getUserIpaUnj(nama : String) : Flow<Result<ApiResponseIpa>>

    suspend fun getUserIpaUinj(nama : String) : Flow<Result<ApiResponseIpa>>
}