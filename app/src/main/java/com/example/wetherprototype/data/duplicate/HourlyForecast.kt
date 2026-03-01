package com.example.wetherprototype.data.duplicate

import androidx.annotation.DrawableRes
import com.example.designsystem.R

data class HourlyForecast(
    @DrawableRes val icon: Int,
    val time: String,
    val temp: String,
)


val hourlyForecastList = listOf(
    HourlyForecast(
        icon = R.drawable.icon_sunny,
        time = "Now",
        temp = "28°C"
    ),
    HourlyForecast(
        icon = R.drawable.icon_snow,
        time = "3 PM",
        temp = "27°C"
    ),
    HourlyForecast(
        icon = R.drawable.icon_rain,
        time = "4 PM",
        temp = "26°C"
    ),
    HourlyForecast(
        icon = R.drawable.icon_storm,
        time = "5 PM",
        temp = "25°C"
    ),
    HourlyForecast(
        icon = R.drawable.icon_drizzle,
        time = "6 PM",
        temp = "24°C"
    ),
    HourlyForecast(
        icon = R.drawable.icon_fog,
        time = "7 PM",
        temp = "22°C"
    ),
    HourlyForecast(
        icon = R.drawable.icon_partly_cloudy,
        time = "8 PM",
        temp = "21°C"
    ),
    HourlyForecast(
        icon = R.drawable.icon_drizzle,
        time = "9 PM",
        temp = "20°C"
    )
)
