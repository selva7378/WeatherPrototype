package com.example.wetherprototype.domain.model.weather

data class Location (
    val latitude: Double,
    val longitude: Double,
    val city: String,
    val country: String,
)


fun Location.formatLocation(): String {
    return "$city, $country"
}