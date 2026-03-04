package com.example.wetherprototype.data.repository

import com.example.wetherprototype.data.mapper.toWeatherData
import com.example.wetherprototype.data.remote.api.WeatherApi
import com.example.wetherprototype.domain.model.weather.Location
import com.example.wetherprototype.domain.model.weather.WeatherData
import com.example.wetherprototype.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeather(
        location: Location,
        tempUnit: String,
        windUnit: String,
        precipitationUnit: String
    ): WeatherData {
        val response = api.getWeatherData(
            lat = location.latitude,
            lon = location.longitude,
            temperature_unit = tempUnit,
            windspeed_unit = windUnit,
            precipitation_unit = precipitationUnit
            )
        return response.toWeatherData(location)
    }
}