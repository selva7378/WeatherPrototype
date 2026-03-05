package com.example.wetherprototype.domain.repository

import com.example.wetherprototype.domain.model.weather.Location
import com.example.wetherprototype.domain.model.weather.WeatherData
import com.example.wetherprototype.domain.util.Result

interface WeatherRepository {
    suspend fun getWeather(
        location: Location,
        tempUnit: String,
        windUnit: String,
        precipitationUnit: String
    ): Result<WeatherData>
}