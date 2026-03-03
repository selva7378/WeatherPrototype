package com.example.wetherprototype.domain.model.weather

data class WeatherData(
    val location: Location,
    val current: CurrentWeather,
    val daily: List<DailyForecast>,
    val hourlySection: HourlySection
)