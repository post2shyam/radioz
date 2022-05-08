package com.androidz.radioz.network

import retrofit2.Call
import retrofit2.http.GET

interface YonderRadiozApiService {
    @GET
    suspend fun getFirstRadioStation(): Call<String>
}