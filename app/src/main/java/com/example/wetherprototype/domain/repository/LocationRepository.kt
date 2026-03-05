package com.example.wetherprototype.domain.repository

import com.example.wetherprototype.domain.model.weather.Location
import com.example.wetherprototype.domain.util.Result


interface LocationRepository {
    suspend fun searchLocation(query: String): Result<List<Location>>
}


