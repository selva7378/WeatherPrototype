package com.example.designsystem.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.designsystem.R
import androidx.compose.ui.draw.blur
import androidx.compose.ui.res.painterResource
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
){
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
//                modifier = Modifier.fillMaxWidth()
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
){

}

@Composable
fun WCurrentWeatherMiniCard(
    name: String,
    value: String,
    modifier: Modifier = Modifier
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier,
    ) {

    }
}

@Composable
fun WCurrentWeatherCard(
    @DrawableRes backgroundImg: Int,
    @DrawableRes iconRes: Int,
    temp: String,
    place: String,
    dayWeek: String,
    day : String,
    month: String,
    year: String,
    modifier: Modifier = Modifier
){

}

@Preview(showBackground = true)
@Composable
fun WDailyForecastCardPreview(){
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