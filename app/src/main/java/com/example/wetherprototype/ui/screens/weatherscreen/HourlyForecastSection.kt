package com.example.wetherprototype.ui.screens.weatherscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.components.WHourlyForecastCard
import com.example.designsystem.theme.WetherPrototypeTheme
import com.example.wetherprototype.domain.model.HourlySection
import com.example.wetherprototype.ui.preview.WeatherPreviewData

@Composable
fun HourlyForecastSection(
    hourlySection: HourlySection,
    modifier: Modifier = Modifier
) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(8.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Hourly Forecast")
                LongBasicDropdownMenu(
                    selectedDay = hourlySection.selectedDay.toString(),
                    days = hourlySection.availableDays.map { it.toString() }
                )
            }

        hourlySection.hourlyByDay[hourlySection.selectedDay]?.forEach { hourlyForecast ->
            WHourlyForecastCard(
                iconRes = hourlyForecast.weatherIcon,
                time = hourlyForecast.time.toString(),
                temp = hourlyForecast.temperature.toString(),
                modifier = Modifier.wrapContentSize()
            )
        }
        }
    }
}

@Composable
fun LongBasicDropdownMenu(
    selectedDay: String,
    days: List<String>,
    modifier: Modifier = Modifier
) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.background(
                MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(16.dp)
            ),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = selectedDay,
                modifier = Modifier.padding(16.dp)
            )
            IconButton(onClick = { expanded = !expanded }) {
                Icon(Icons.Default.MoreVert, contentDescription = "More options")
            }
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            days.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = { /* Do something... */ }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HourlyForecastSectionPreview(){
    WetherPrototypeTheme {
        HourlyForecastSection(
            hourlySection = WeatherPreviewData.weather.hourlySection
        )
    }
}