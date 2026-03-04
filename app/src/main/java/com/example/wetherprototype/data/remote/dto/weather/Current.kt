package com.example.wetherprototype.data.remote.dto.weather

import kotlinx.serialization.Serializable

@Serializable
data class Current(
    val apparent_temperature: Double,
    val interval: Int,
    val precipitation: Double,
    val relative_humidity_2m: Int,
    val temperature_2m: Double,
    val time: String,
    val weather_code: Int,
    val wind_speed_10m: Double
)