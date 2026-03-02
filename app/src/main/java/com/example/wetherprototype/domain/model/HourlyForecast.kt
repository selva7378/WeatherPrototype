package com.example.wetherprototype.domain.model

import androidx.annotation.DrawableRes
import java.time.LocalTime

data class HourlyForecast(
    val time: LocalTime,      // For "3 PM"
    val temperature: Int,
    @DrawableRes val weatherIcon: Int
)