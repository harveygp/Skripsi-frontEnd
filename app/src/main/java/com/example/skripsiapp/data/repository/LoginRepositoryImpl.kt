package com.example.skripsiapp.data.repository

import android.util.Log
import com.example.skripsiapp.data.remote.response.ApiResponseLogin
import com.example.skripsiapp.data.remote.retrofit.ApiService
import com.example.skripsiapp.domain.UserRepository.LoginRepository
import com.example.skripsiapp.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val api : ApiService
) : LoginRepository {

    override suspend fun getUserLoginIpa(nama: String): Flow<Result<ApiResponseLogin>> = flow {
        try {
            emit(Result.Loading())
            val response = api.getLoginIpa(nama)
            Log.d("data", response.toString())
            emit(Result.Success(response))
        }catch(e : HttpException){
            emit(Result.Error(e.localizedMessage ?: "An Error Occurred"))
        }catch (e : NullPointerException){
            emit(Result.Error(e.localizedMessage ?: "An Error Occurred"))
        }
    }

    override suspend fun getUserLoginIps(nama: String): Flow<Result<ApiResponseLogin>> = flow {
        try {
            emit(Result.Loading())
            val response = api.getLoginIps(nama)
            Log.d("data", response.toString())
            emit(Result.Success(response))
        }catch(e : HttpException){
            emit(Result.Error(e.localizedMessage ?: "An Error Occurred"))
        }catch (e : NullPointerException){
            emit(Result.Error(e.localizedMessage ?: "An Error Occurred"))
        }
    }

}