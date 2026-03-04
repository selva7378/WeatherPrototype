package com.example.wetherprototype.domain.model.weather

import androidx.annotation.DrawableRes
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

data class CurrentWeather(
    val date: LocalDate,
    val temperature: Double,
    val humidity: Int,
    val windSpeed: Double,
    val feelsLike: Int,
    val precipitation: Int,
    val tempUnit: String,
    val windUnit: String,
    val humidityUnit: String,
    val precipitationUnit: String,
    @DrawableRes val weatherIcon: Int,
)

fun LocalDate.toFullDateString(): String {
    val formatter = DateTimeFormatter.ofPattern(
        "EEEE, MMMM d, yyyy",
        Locale.getDefault()
    )
    return this.format(formatter)
}