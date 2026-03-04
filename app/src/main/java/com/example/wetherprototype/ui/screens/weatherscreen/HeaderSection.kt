package com.example.wetherprototype.ui.screens.weatherscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystem.R
import com.example.designsystem.theme.WeatherPrototypeTheme
import com.example.wetherprototype.domain.model.units.PrecipitationUnit
import com.example.wetherprototype.domain.model.units.TemperatureUnit
import com.example.wetherprototype.domain.model.units.WindUnit
import com.example.wetherprototype.ui.viewmodels.UnitsUiState


@Composable
fun HeaderSection(
    unitsState:  UnitsUiState,
    onTemperatureSelected: (TemperatureUnit) -> Unit,
    onWindSelected: (WindUnit) -> Unit,
    onPrecipitationSelected: (PrecipitationUnit) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null
            )
            UnitsMenu(
                state = unitsState,
                onTemperatureSelected = onTemperatureSelected,
                onWindSelected = onWindSelected,
                onPrecipitationSelected = onPrecipitationSelected,
            )

        }

        Text(
            text = "How's the sky looking today ?",
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Center,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderSectionPreview() {
    WeatherPrototypeTheme {
        HeaderSection(
            unitsState = UnitsUiState(),
            onTemperatureSelected = {},
            onWindSelected = {},
            onPrecipitationSelected = {}
        )
    }
}

