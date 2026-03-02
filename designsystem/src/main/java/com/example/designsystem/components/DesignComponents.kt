package com.example.designsystem.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.designsystem.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.WetherPrototypeTheme

@Composable
fun WDailyForecastCard(
    day: String,
    @DrawableRes iconRes: Int,
    highTemp: String,
    lowTemp: String,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = day,
            )
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(highTemp)
                Text(lowTemp)
            }
        }
    }
}

@Composable
fun WHourlyForecastCard(
    @DrawableRes iconRes: Int,
    time: String,
    temp: String,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )
            Text(
                text = time,
                modifier = Modifier.weight(1f)
            )
            Text(temp)
        }
    }
}

@Composable
fun WHighlightCard(
    name: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp).fillMaxWidth()
        ) {
            Text(name)

            Spacer(modifier = Modifier.padding(8.dp))

            Text(value)
        }
    }
}

@Composable
fun WCurrentWeatherCard(
    @DrawableRes backgroundImg: Int,
    @DrawableRes iconRes: Int,
    temp: String,
    place: String,
    dayAndDate: String,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier.fillMaxWidth().height(240.dp).wrapContentSize(),
    ) {
        Box {
            Image(
                painter = painterResource(backgroundImg),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize().padding(8.dp)
            ) {
                Text(place)
                Text(
                    text = dayAndDate,

                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(iconRes),
                        contentDescription = null
                        )
                    Text(
                        text = temp,
                        style = MaterialTheme.typography.displayLarge.copy(
                            fontStyle = FontStyle.Italic
                        )
                        )
                }
            }
        }
    }
}

@Composable
fun HourlyForecast(
    modifier: Modifier = Modifier
) {

}

@Preview(showBackground = true)
@Composable
fun WDailyForecastCardPreview() {
    WetherPrototypeTheme() {
        WDailyForecastCard(
            day = "Monday",
            iconRes = R.drawable.icon_rain,
            highTemp = "20°",
            lowTemp = "30 °",
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WHourlyForecastCardPreview() {
    WetherPrototypeTheme() {
        WHourlyForecastCard(
            iconRes = R.drawable.icon_snow,
            time = "12:00",
            temp = "20°",
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WHighlightCardPreview() {
    WetherPrototypeTheme() {
        WHighlightCard(
            name = "Humidity",
            value = "80%",
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WCurrentWeatherCardPreview() {
    WetherPrototypeTheme() {
        WCurrentWeatherCard(
            backgroundImg = R.drawable.bg_today_small,
            iconRes = R.drawable.icon_snow,
            temp = "20°",
            place = "New York",
            dayAndDate = "Tuesday, Aug 5, 2025",
            modifier = Modifier,
        )
    }
}