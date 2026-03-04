package com.example.wetherprototype.domain.model.weather

import java.time.DayOfWeek

data class HourlySection(
    val availableDays: List<DayOfWeek>,
    val selectedDay: DayOfWeek,
    val hourlyByDay: Map<DayOfWeek, List<HourlyForecast>>
)

fun HourlySection.hourlyForSelectedDay(): List<HourlyForecast> {
    return hourlyByDay[selectedDay].orEmpty()
}