package com.androidz.radioz.repository

import com.androidz.radioz.network.YonderRadiozApiService


class Repository(private val yonderRadiozApiService: YonderRadiozApiService) {
    suspend fun getFavoriteRadioStations() = yonderRadiozApiService.getFavoriteRadioStations()
}
