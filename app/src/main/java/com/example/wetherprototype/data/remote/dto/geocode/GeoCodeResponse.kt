package com.example.wetherprototype.data.remote.dto.geocode

import kotlinx.serialization.Serializable

data class GeoCodeResponse(
    val generationtime_ms: Double,
    val results: List<Result>
)