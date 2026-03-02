package com.example.wetherprototype.domain.model

data class Location (
    val city: String,
    val country: String,
)


fun Location.formatLocation(): String {
    return "$city, $country"
}