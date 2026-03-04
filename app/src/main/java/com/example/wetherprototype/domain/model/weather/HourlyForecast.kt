package com.example.wetherprototype.domain.model.weather

import androidx.annotation.DrawableRes
import java.time.LocalTime

data class HourlyForecast(
    val time: LocalTime,      // For "3 PM"
    val temperature: Int,
    val unitTemp: String,
//    val unitTime: String,
    @DrawableRes val weatherIcon: Int
)