package com.example.skripsiapp.utils

sealed class Result<T>(val response: T? = null, val message: String? = null) {
    class Success<T>(response: T) : Result<T>(response)
    class Error<T>(message: String, response: T? = null) : Result<T>(response, message)
    class Loading<T>(response: T? = null) : Result<T>(response)
}