package com.androidz.radioz.network

import com.squareup.moshi.Json

data class FavoriteStationsModel(
    @field:Json(name = "stations")
    var stations: List<String>?
)
