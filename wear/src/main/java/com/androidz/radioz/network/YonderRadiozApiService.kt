package com.androidz.radioz.network

import retrofit2.Response
import retrofit2.http.GET

interface YonderRadiozApiService {
    @GET("/favoritestations")
    suspend fun getFavoriteRadioStations(): Response<FavoriteStationsModel>
}