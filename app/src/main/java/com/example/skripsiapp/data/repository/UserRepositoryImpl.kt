package com.example.skripsiapp.data.repository

import android.util.Log
import com.example.skripsiapp.data.remote.response.ApiResponseIpa
import com.example.skripsiapp.data.remote.response.ApiResponseIps
import com.example.skripsiapp.data.remote.retrofit.ApiService
import com.example.skripsiapp.domain.UserRepository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject
import com.example.skripsiapp.utils.Result

class UserRepositoryImpl @Inject constructor(
    private val api : ApiService
) : UserRepository {
    override suspend fun getUserIpsUpnvj(nama: String): Flow<Result<ApiResponseIps>> = flow {
        try {
            emit(Result.Loading())
            val response = api.getUserIpsUpnvj(nama)
            emit(Result.Success(response))
        }catch(e : HttpException){
            emit(Result.Error(e.localizedMessage ?: "An Error Occurred"))
        }catch (e : NullPointerException){
            emit(Result.Error(e.localizedMessage ?: "An Error Occurred"))
        }
    }

    override suspend fun getUserIpsUnj(nama: String): Flow<Result<ApiResponseIps>> = flow {
        try {
            emit(Result.Loading())
            val response = api.getUserIpsUnj(nama)
            emit(Result.Success(response))
        }catch(e : HttpException){
            emit(Result.Error(e.localizedMessage ?: "An Error Occurred"))
        }catch (e : NullPointerException){
            emit(Result.Error(e.localizedMessage ?: "An Error Occurred"))
        }
    }

    override suspend fun getUserIpsUinj(nama: String): Flow<Result<ApiResponseIps>> = flow{
        try {
            emit(Result.Loading())
            val response = api.getUserIpsUinj(nama)
            emit(Result.Success(response))
        }catch(e : HttpException){
            emit(Result.Error(e.localizedMessage ?: "An Error Occurred"))
        }catch (e : NullPointerException){
            emit(Result.Error(e.localizedMessage ?: "An Error Occurred"))
        }
    }

    override suspend fun getUserIpaUpnvj(nama: String): Flow<Result<ApiResponseIpa>> = flow{
        try {
            emit(Result.Loading())
            val response = api.getUserIpaUpnvj(nama)
            emit(Result.Success(response))
        }catch(e : HttpException){
            emit(Result.Error(e.localizedMessage ?: "An Error Occurred"))
        }catch (e : NullPointerException){
            emit(Result.Error(e.localizedMessage ?: "An Error Occurred"))
        }
    }

    override suspend fun getUserIpaUnj(nama: String): Flow<Result<ApiResponseIpa>> = flow{
        try {
            emit(Result.Loading())
            val response = api.getUserIpaUnj(nama)
            emit(Result.Success(response))
        }catch(e : HttpException){
            emit(Result.Error(e.localizedMessage ?: "An Error Occurred"))
        }catch (e : NullPointerException){
            emit(Result.Error(e.localizedMessage ?: "An Error Occurred"))
        }
    }

    override suspend fun getUserIpaUinj(nama: String): Flow<Result<ApiResponseIpa>> = flow{
        try {
            emit(Result.Loading())
            val response = api.getUserIpaUinj(nama)
            emit(Result.Success(response))
        }catch(e : HttpException){
            emit(Result.Error(e.localizedMessage ?: "An Error Occurred"))
        }catch (e : NullPointerException){
            emit(Result.Error(e.localizedMessage ?: "An Error Occurred"))
        }
    }

}