package com.example.wetherprototype.data

import androidx.annotation.DrawableRes
import com.example.designsystem.R

data class DailyForecast(
    @DrawableRes val icon: Int,
    val day: String,
    val lowTemp: String,
    val highTemp: String,
)

val dailyForecastList = listOf(
    DailyForecast(
        icon = R.drawable.icon_sunny,
        day = "Monday",
        lowTemp = "18°C",
        highTemp = "28°C"
    ),
    DailyForecast(
        icon = R.drawable.icon_partly_cloudy,
        day = "Tuesday",
        lowTemp = "17°C",
        highTemp = "24°C"
    ),
    DailyForecast(
        icon = R.drawable.icon_rain,
        day = "Wednesday",
        lowTemp = "15°C",
        highTemp = "21°C"
    ),
    DailyForecast(
        icon = R.drawable.icon_fog,
        day = "Thursday",
        lowTemp = "19°C",
        highTemp = "26°C"
    ),
    DailyForecast(
        icon = R.drawable.icon_snow,
        day = "Friday",
        lowTemp = "20°C",
        highTemp = "30°C"
    ),
    DailyForecast(
        icon = R.drawable.icon_drizzle,
        day = "Saturday",
        lowTemp = "22°C",
        highTemp = "32°C"
    ),
    DailyForecast(
        icon = R.drawable.icon_storm,
        day = "Sunday",
        lowTemp = "18°C",
        highTemp = "25°C"
    )
)

