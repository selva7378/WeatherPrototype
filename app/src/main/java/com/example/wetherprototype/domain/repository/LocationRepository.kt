package com.example.wetherprototype.domain.repository

import com.example.wetherprototype.domain.model.weather.Location

interface LocationRepository {
    suspend fun searchLocation(query: String): List<Location>
}


