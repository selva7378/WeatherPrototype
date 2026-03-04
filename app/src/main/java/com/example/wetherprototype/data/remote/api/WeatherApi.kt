package com.example.wetherprototype.data.remote.api

import com.example.wetherprototype.data.remote.dto.weather.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("v1/forecast")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") lon: Double,
        @Query("current") current: String = "temperature_2m,relative_humidity_2m,apparent_temperature,precipitation,weather_code,wind_speed_10m",
        @Query("hourly") hourly: String = "temperature_2m,weather_code",
        @Query("daily") daily: String = "weather_code,temperature_2m_max,temperature_2m_min",
        @Query("timezone") timezone: String = "auto",
        @Query("temperature_unit") temperature_unit: String = "celsius",
        @Query("windspeed_unit") windspeed_unit: String = "kmh",
        @Query("precipitation_unit") precipitation_unit: String = "mm"
    ): WeatherResponse
}