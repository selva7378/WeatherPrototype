package com.example.wetherprototype.domain.model

data class WeatherUiModel(
    val location: Location,
    val current: CurrentWeather,
    val daily: List<DailyForecast>,
    val hourlySection: HourlySection
)