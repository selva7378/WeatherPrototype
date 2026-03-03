package com.example.wetherprototype.data.remote.dto.weather

import kotlinx.serialization.Serializable

@Serializable
data class HourlyUnits(
    val temperature_2m: String,
    val time: String,
    val weather_code: String
)