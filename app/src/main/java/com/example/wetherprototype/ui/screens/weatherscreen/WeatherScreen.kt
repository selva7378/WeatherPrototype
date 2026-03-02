package com.example.wetherprototype.ui.screens.weatherscreen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.designsystem.R
import com.example.designsystem.components.WCurrentWeatherCard
import com.example.designsystem.theme.WetherPrototypeTheme
import com.example.wetherprototype.domain.model.formatLocation
import com.example.wetherprototype.domain.model.toFullDateString
import com.example.wetherprototype.ui.viewmodels.WeatherScreenViewModel

@Composable
fun WeatherScreen(
    weatherScreenViewModel: WeatherScreenViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {

    val weatherData by weatherScreenViewModel.weather.collectAsStateWithLifecycle()


    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item {
            HeaderSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(align = Alignment.Center)
            )
        }

//        item { SearchSection() }

        item {
            WCurrentWeatherCard(
                backgroundImg = R.drawable.bg_today_small,
                iconRes = weatherData.current.weatherIcon,
                temp = weatherData.current.temperature.toString(),
                place = weatherData.location.formatLocation(),
                dayAndDate = weatherData.current.date.toFullDateString(),
                modifier = Modifier.padding(12.dp)
            )
        }

        item {
            HighlightsSection(
                feelsLike = weatherData.current.feelsLike.toString(),
                humidity = weatherData.current.humidity.toString(),
                wind = weatherData.current.windSpeed.toString(),
                precipitation = weatherData.current.precipitation.toString(),
                modifier = modifier
            )
        }

        item { DailyForecastSection(
            dailyForecastList = weatherData.daily.chunked(3)
        ) }

        item { HourlyForecastSection(weatherData.hourlySection) }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherPreview() {
    WetherPrototypeTheme() {
        WeatherScreen()
    }
}