package com.example.wetherprototype.ui.screens.weatherscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.components.WHighlightCard

@Composable
fun HighlightsSection(
    feelsLike: String,
    humidity: String,
    wind: String,
    precipitation: String,
    modifier: Modifier = Modifier
) {

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
    ) {

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            WHighlightCard("Feels Like", feelsLike, Modifier.weight(1f))
            WHighlightCard("Humidity", humidity, Modifier.weight(1f))
        }

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            WHighlightCard("Wind", wind, Modifier.weight(1f))
            WHighlightCard("Precipitation", precipitation, Modifier.weight(1f))
        }
    }
}


@Preview
@Composable
fun HighlightsSectionPreview() {
    HighlightsSection(
        feelsLike = "20°",
        humidity = "80%",
        wind = "10 Km/h",
        precipitation = "20 mm"
    )
}
