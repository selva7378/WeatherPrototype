package com.example.wetherprototype.domain.model

import androidx.annotation.DrawableRes
import java.time.DayOfWeek

data class DailyForecast(
    val day: DayOfWeek,       //for mon, tue, etc.
    val maxTemp: Int,
    val minTemp: Int,
    @DrawableRes val iconRes: Int
)