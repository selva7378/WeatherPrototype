package com.example.wetherprototype.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.R
import com.example.designsystem.components.WCurrentWeatherCard
import com.example.designsystem.components.WDailyForecastCard
import com.example.designsystem.theme.WetherPrototypeTheme
import com.example.wetherprototype.data.dailyForecastList

@Composable
fun WeatherScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    )
    {
        Column(
            modifier = modifier.fillMaxSize(),
        ) {
            Text(
                text = "How's the sky looking today ?",
                style = MaterialTheme.typography.displayLarge,
                textAlign = TextAlign.Center
            )
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(12.dp).fillMaxWidth()
                ) {
//                    SearchBar() { }
                    Text(
                        text = "Search",
                        textAlign = TextAlign.Center
                        )
                }
                WCurrentWeatherCard(
                    backgroundImg = R.drawable.bg_today_small,
                    iconRes = R.drawable.icon_sunny,
                    temp = "20°",
                    place = "New York",
                    dayAndDate = "Tuesday, Aug 5, 2025",
                    modifier = Modifier.padding(12.dp)
                )
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 128.dp)
                ) {
                    items(dailyForecastList) { forecast ->
                        WDailyForecastCard(
                            day = forecast.d,
                            iconRes = TODO(),
                            highTemp = TODO(),
                            lowTemp = TODO(),
                            modifier = TODO()
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeatherPreview() {
    WetherPrototypeTheme() {
        WeatherScreen()
    }
}