package com.example.wetherprototype.data.mapper

import com.example.designsystem.R
import com.example.wetherprototype.data.remote.dto.geocode.GeoCodeResponse
import com.example.wetherprototype.data.remote.dto.weather.WeatherResponse
import com.example.wetherprototype.domain.model.weather.CurrentWeather
import com.example.wetherprototype.domain.model.weather.DailyForecast
import com.example.wetherprototype.domain.model.weather.HourlyForecast
import com.example.wetherprototype.domain.model.weather.HourlySection
import com.example.wetherprototype.domain.model.weather.Location
import com.example.wetherprototype.domain.model.weather.WeatherData
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun GeoCodeResponse.toLocationList(): List<Location> {
    return results.map {
        Location(
            latitude = it.latitude,
            longitude = it.longitude,
            city = it.name,
            country = it.country
        )
    }
}

fun WeatherResponse.toWeatherData(location: Location): WeatherData {
    val dailyForecasts = daily.time.indices.map { i ->
        DailyForecast(
            day = LocalDate.parse(daily.time[i]).dayOfWeek,
            maxTemp = daily.temperature_2m_max[i].toInt(),
            minTemp = daily.temperature_2m_min[i].toInt(),
            iconRes = getWeatherIcon(daily.weather_code[i])
        )
    }

    val hourlyForecasts = hourly.time.indices.map { i ->
        val dateTime = hourly.time[i]
        val date = LocalDate.parse(dateTime.substring(0, 10))
        val time = LocalTime.parse(dateTime.substring(11, 16), DateTimeFormatter.ofPattern("HH:mm"))
        
        date to HourlyForecast(
            time = time,
            temperature = hourly.temperature_2m[i].toInt(),
            weatherIcon = getWeatherIcon(hourly.weather_code[i])
        )
    }

    val hourlyByDay = hourlyForecasts.groupBy({ it.first }, { it.second })
        .mapKeys { it.key.dayOfWeek }

    val currentDay = LocalDate.now()
    
    val currentWeather = CurrentWeather(
        date = currentDay,
        temperature = current.temperature_2m,
        humidity = current.relative_humidity_2m,
        windSpeed = current.wind_speed_10m,
        feelsLike = current.apparent_temperature.toInt(),
        precipitation = current.precipitation.toInt(),
        weatherIcon = getWeatherIcon(current.weather_code)
    )

    return WeatherData(
        location = location,
        current = currentWeather,
        daily = dailyForecasts,
        hourlySection = HourlySection(
            availableDays = hourlyByDay.keys.toList(),
            selectedDay = currentDay.dayOfWeek,
            hourlyByDay = hourlyByDay
        )
    )
}

private fun getWeatherIcon(code: Int): Int {
    return when (code) {
        0 -> R.drawable.icon_sunny
        1, 2, 3 -> R.drawable.icon_partly_cloudy
        45, 48 -> R.drawable.icon_fog
        51, 53, 55, 56, 57 -> R.drawable.icon_drizzle
        61, 63, 65, 66, 67 -> R.drawable.icon_rain
        71, 73, 75, 77 -> R.drawable.icon_snow
        80, 81, 82 -> R.drawable.icon_rain
        85, 86 -> R.drawable.icon_snow
        95, 96, 99 -> R.drawable.icon_storm
        else -> R.drawable.icon_sunny
    }
}