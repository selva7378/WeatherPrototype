package com.example.wetherprototype.data.remote.dto.weather

import kotlinx.serialization.Serializable

@Serializable
data class Daily(
    val temperature_2m_max: List<Double>,
    val temperature_2m_min: List<Double>,
    val time: List<String>,
    val weather_code: List<Int>
)