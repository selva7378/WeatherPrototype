package com.example.wetherprototype.data.remote.dto.weather

import kotlinx.serialization.Serializable

@Serializable
data class CurrentUnits(
    val apparent_temperature: String,
    val interval: String,
    val precipitation: String,
    val relative_humidity_2m: String,
    val temperature_2m: String,
    val time: String,
    val weather_code: String,
    val wind_speed_10m: String
)