package com.example.wetherprototype.data.repository

import com.example.wetherprototype.domain.model.weather.WeatherData
import com.example.wetherprototype.domain.repository.WeatherRepository

class WeatherRepositoryImpl: WeatherRepository {
    override suspend fun getWeather(
        lat: Double,
        lon: Double
    ): WeatherData {
        TODO("Not yet implemented")
    }
}