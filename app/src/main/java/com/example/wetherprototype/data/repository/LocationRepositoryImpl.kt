package com.example.wetherprototype.data.repository

import android.util.Log
import com.example.wetherprototype.data.mapper.toLocationList
import com.example.wetherprototype.data.remote.api.GeocodingApi
import com.example.wetherprototype.domain.model.weather.Location
import com.example.wetherprototype.domain.repository.LocationRepository
import javax.inject.Inject
import com.example.wetherprototype.domain.util.Result


class LocationRepositoryImpl @Inject constructor(
    private val api: GeocodingApi
) : LocationRepository {

    override suspend fun searchLocation(query: String): Result<List<Location>> {
        return try {
            val locations = api.searchLocation(name = query).toLocationList()
            Result.Success(locations)
        } catch (e: Exception) {
            Log.e("LocationRepositoryImpl", "errorLocation: ${e.message}")
            Result.Error(e)
        }
    }
}