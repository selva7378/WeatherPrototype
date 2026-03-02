package com.example.wetherprototype.ui.preview

import com.example.designsystem.R
import com.example.wetherprototype.domain.model.CurrentWeather
import com.example.wetherprototype.domain.model.DailyForecast
import com.example.wetherprototype.domain.model.HourlyForecast
import com.example.wetherprototype.domain.model.HourlySection
import com.example.wetherprototype.domain.model.Location
import com.example.wetherprototype.domain.model.WeatherUiModel
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime

object WeatherPreviewData {

    val weather = WeatherUiModel(
        location = Location(
            city = "Berlin",
            country = "Germany"
        ),
        current = CurrentWeather(
            date = LocalDate.of(2025, 8, 5),
            temperature = 20.0,
            feelsLike = 18,
            humidity = 46,
            windSpeed = 14.0,
            precipitation = 0,
            weatherIcon = R.drawable.icon_drizzle
        ),
        daily = listOf(
            DailyForecast(DayOfWeek.TUESDAY, 20, 14, R.drawable.icon_fog),
            DailyForecast(DayOfWeek.WEDNESDAY, 21, 15, R.drawable.icon_storm),
            DailyForecast(DayOfWeek.THURSDAY, 24, 14, R.drawable.icon_snow),
            DailyForecast(DayOfWeek.FRIDAY, 25, 13, R.drawable.icon_sunny),
            DailyForecast(DayOfWeek.SATURDAY, 21, 15, R.drawable.icon_partly_cloudy),
            DailyForecast(DayOfWeek.SUNDAY, 25, 16, R.drawable.icon_sunny),
            DailyForecast(DayOfWeek.MONDAY, 24, 15, R.drawable.icon_snow)
        ),
        hourlySection = HourlySection(
            availableDays = listOf(
                DayOfWeek.TUESDAY,
                DayOfWeek.WEDNESDAY,
                DayOfWeek.THURSDAY,
                DayOfWeek.SUNDAY
            ),
            selectedDay = DayOfWeek.TUESDAY,
            hourlyByDay = mapOf(

                DayOfWeek.TUESDAY to listOf(
                    HourlyForecast(LocalTime.of(6, 0), 18, R.drawable.icon_sunny),
                    HourlyForecast(LocalTime.of(9, 0), 21, R.drawable.icon_partly_cloudy),
                    HourlyForecast(LocalTime.of(12, 0), 26, R.drawable.icon_sunny),
                    HourlyForecast(LocalTime.of(15, 0), 28, R.drawable.icon_sunny),
                    HourlyForecast(LocalTime.of(18, 0), 24, R.drawable.icon_drizzle),
                    HourlyForecast(LocalTime.of(21, 0), 20, R.drawable.icon_fog)
                ),

                DayOfWeek.WEDNESDAY to listOf(
                    HourlyForecast(LocalTime.of(6, 0), 17, R.drawable.icon_fog),
                    HourlyForecast(LocalTime.of(12, 0), 25, R.drawable.icon_storm),
                    HourlyForecast(LocalTime.of(18, 0), 22, R.drawable.icon_storm)
                ),

                DayOfWeek.THURSDAY to listOf(
                    HourlyForecast(LocalTime.of(8, 0), 19, R.drawable.icon_partly_cloudy),
                    HourlyForecast(LocalTime.of(14, 0), 27, R.drawable.icon_sunny),
                    HourlyForecast(LocalTime.of(20, 0), 21, R.drawable.icon_drizzle)
                ),

                DayOfWeek.SUNDAY to listOf(
                    HourlyForecast(LocalTime.of(10, 0), 23, R.drawable.icon_fog),
                    HourlyForecast(LocalTime.of(16, 0), 26, R.drawable.icon_sunny)
                )
            )
        )
    )

}