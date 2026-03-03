package com.example.wetherprototype.data.remote.api

import com.example.wetherprototype.data.remote.dto.geocode.GeoCodeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApi {

    @GET("v1/search")
    suspend fun searchLocation(
        @Query("name") name: String,
        @Query("count") count: Int = 10,
        @Query("language") language: String = "en",
        @Query("format") format: String = "json"
    ): GeoCodeResponse
}