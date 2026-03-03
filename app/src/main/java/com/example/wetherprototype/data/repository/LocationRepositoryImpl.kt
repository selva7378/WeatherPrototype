package com.example.wetherprototype.data.repository

import com.example.wetherprototype.data.remote.api.GeocodingApi
import com.example.wetherprototype.domain.model.weather.Location
import com.example.wetherprototype.domain.repository.LocationRepository
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val api: GeocodingApi
) : LocationRepository {
    override suspend fun searchLocation(query: String): List<Location> {
        api.searchLocation(name = query).results.
    }
}