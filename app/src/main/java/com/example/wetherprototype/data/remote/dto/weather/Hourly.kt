package com.example.wetherprototype.data.remote.dto.weather

import kotlinx.serialization.Serializable

@Serializable
data class Hourly(
    val temperature_2m: List<Double>,
    val time: List<String>,
    val weather_code: List<Int>
)