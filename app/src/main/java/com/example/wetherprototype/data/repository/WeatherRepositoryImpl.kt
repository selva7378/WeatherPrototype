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
    override suspend fun getWeather(location: Location): WeatherData {
        val response = api.getWeatherData(location.latitude, location.longitude)
        return response.toWeatherData(location)
    }
}