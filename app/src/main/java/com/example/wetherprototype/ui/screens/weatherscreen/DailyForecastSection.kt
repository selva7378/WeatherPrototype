package com.example.wetherprototype.ui.screens.weatherscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.components.WDailyForecastCard
import com.example.wetherprototype.domain.model.DailyForecast
import com.example.wetherprototype.ui.preview.WeatherPreviewData

@Composable
fun DailyForecastSection(
    dailyForecastList: List<List<DailyForecast>>,
    modifier: Modifier = Modifier
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {

        Text("Daily Forecast")

        dailyForecastList.forEach { rowItems ->
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                rowItems.forEach { dailForecast ->
                    WDailyForecastCard(
                        day = dailForecast.day.name,
                        iconRes = dailForecast.iconRes,
                        highTemp = dailForecast.maxTemp.toString(),
                        lowTemp = dailForecast.minTemp.toString(),
                        modifier = Modifier.weight(1f)
                    )
                }

                if (rowItems.size == 2) {
                    Spacer(Modifier.weight(1f))
                }
                if (rowItems.size == 1) {
                    Spacer(Modifier.weight(2f))
                }
            }
        }
    }
}

@Preview
@Composable
fun DailyForecastSectionPreview() {
    DailyForecastSection(
        dailyForecastList = WeatherPreviewData.weather.daily.chunked(3)
    )
}