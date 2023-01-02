package com.example.skripsiapp.data.remote.retrofit

import com.example.skripsiapp.data.remote.response.ApiResponseIpa
import com.example.skripsiapp.data.remote.response.ApiResponseIps
import com.example.skripsiapp.data.remote.response.ApiResponseLogin
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/univ/upnvj/ips/{nama}")
    suspend fun getUserIpsUpnvj(@Path("nama") nama : String) : ApiResponseIps

    @GET("api/univ/unj/ips/{nama}")
    suspend fun getUserIpsUnj(@Path("nama") nama : String) : ApiResponseIps

    @GET("api/univ/uinj/ips/{nama}")
    suspend fun getUserIpsUinj(@Path("nama") nama : String) : ApiResponseIps

    @GET("api/univ/upnvj/ipa/{nama}")
    suspend fun getUserIpaUpnvj(@Path("nama") nama : String) : ApiResponseIpa

    @GET("api/univ/unj/ipa/{nama}")
    suspend fun getUserIpaUnj(@Path("nama") nama : String) : ApiResponseIpa

    @GET("api/univ/uinj/ipa/{nama}")
    suspend fun getUserIpaUinj(@Path("nama") nama : String) : ApiResponseIpa

    @GET("api/student/ips/{nama}")
    suspend fun getLoginIps(@Path("nama") nama : String) : ApiResponseLogin

    @GET("api/student/ipa/{nama}")
    suspend fun getLoginIpa(@Path("nama") nama : String) : ApiResponseLogin
}