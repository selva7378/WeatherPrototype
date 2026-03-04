package com.example.wetherprototype.ui.screens.weatherscreen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.designsystem.R
import com.example.designsystem.components.WCurrentWeatherCard
import com.example.designsystem.theme.WeatherPrototypeTheme
import com.example.wetherprototype.domain.model.weather.formatLocation
import com.example.wetherprototype.domain.model.weather.toFullDateString
import com.example.wetherprototype.ui.viewmodels.WeatherScreenViewModel

@Composable
fun WeatherScreen(
    weatherScreenViewModel: WeatherScreenViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val weatherData by weatherScreenViewModel.weather.collectAsStateWithLifecycle()
    val searchData by weatherScreenViewModel.searchState.collectAsStateWithLifecycle()
    val unitState by weatherScreenViewModel.unitState.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item {
            HeaderSection(
                unitsState = unitState,
                onTemperatureSelected = weatherScreenViewModel::onTemperatureSelected,
                onWindSelected = weatherScreenViewModel::onWindSelected,
                onPrecipitationSelected = weatherScreenViewModel::onPrecipitationSelected,
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            SearchSection(
                state = searchData,
                onQueryChange = weatherScreenViewModel::onQueryChange,
                suggestionsDelete = weatherScreenViewModel::deleteSuggestion,
                onLocationClick = weatherScreenViewModel::fetchWeather
            )
        }

        when {
            weatherData.isLoading -> {
                item {
                    Box(Modifier.fillParentMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }
            }
            weatherData.error != null -> {
                item {
//                    ErrorComponent(message = weatherData.error!!) // Show error message
                }
            }
            weatherData.data != null -> {
                val data = weatherData.data!!

                item {
                    WCurrentWeatherCard(
                        backgroundImg = R.drawable.bg_today_small,
                        iconRes = data.current.weatherIcon,
                        temp = data.current.temperature.toString(),
                        place = data.location.formatLocation(),
                        dayAndDate = data.current.date.toFullDateString(),
                        tempUnit = data.current.tempUnit
                    )
                }

                item {
                    HighlightsSection(
                        feelsLike = data.current.feelsLike.toString(),
                        humidity = data.current.humidity.toString(),
                        wind = data.current.windSpeed.toString(),
                        precipitation = data.current.precipitation.toString(),
                        temperatureUnit = data.current.tempUnit,
                        windUnit = data.current.windUnit,
                        precipitationUnit = data.current.precipitationUnit,
                        humidityUnit = data.current.humidityUnit,
                        modifier = Modifier,
                    )
                }

                item {
                    DailyForecastSection(dailyForecastList = data.daily.chunked(3))
                }

                item {
                    HourlyForecastSection(
                        hourlySection = data.hourlySection,
                        onDaySelected = weatherScreenViewModel::onDaySelected
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WeatherPreview() {
    WeatherPrototypeTheme() {
        WeatherScreen()
    }
}