package com.example.wetherprototype.ui.screens.weatherscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.wetherprototype.domain.model.units.PrecipitationUnit
import com.example.wetherprototype.domain.model.units.TemperatureUnit
import com.example.wetherprototype.domain.model.units.WindUnit
import com.example.wetherprototype.ui.viewmodels.UnitsUiState

@Composable
fun UnitsMenu(
    state: UnitsUiState,
    onTemperatureSelected: (TemperatureUnit) -> Unit,
    onWindSelected: (WindUnit) -> Unit,
    onPrecipitationSelected: (PrecipitationUnit) -> Unit,
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
                text = "Units",
                modifier = Modifier.padding(16.dp)
            )
            IconButton(onClick = { expanded = !expanded }) {
                Icon(Icons.Default.MoreVert, contentDescription = "More options")
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = !expanded
            },
            shape = RoundedCornerShape(20.dp),
            containerColor = MaterialTheme.colorScheme.surface,
            offset = DpOffset(x = 0.dp, y = 8.dp)
        ) {

            Surface(
                modifier = Modifier.width(280.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    Text("Temperature")

                    UnitRow(
                        text = "Celsius (°C)",
                        selected = state.temperatureUnit == TemperatureUnit.CELSIUS,
                        onClick = { onTemperatureSelected(TemperatureUnit.CELSIUS) }
                    )

                    UnitRow(
                        text = "Fahrenheit (°F)",
                        selected = state.temperatureUnit == TemperatureUnit.FAHRENHEIT,
                        onClick = { onTemperatureSelected(TemperatureUnit.FAHRENHEIT) }
                    )

                    Divider(Modifier.padding(vertical = 12.dp))

                    Text("Wind Speed")

                    UnitRow(
                        text = "km/h",
                        selected = state.windUnit == WindUnit.KMH,
                        onClick = { onWindSelected(WindUnit.KMH) }
                    )

                    UnitRow(
                        text = "mph",
                        selected = state.windUnit == WindUnit.MPH,
                        onClick = { onWindSelected(WindUnit.MPH) }
                    )

                    HorizontalDivider(
                        Modifier.padding(vertical = 12.dp),
                        DividerDefaults.Thickness,
                        DividerDefaults.color
                    )

                    Text("Precipitation")

                    UnitRow(
                        text = "Millimeters (mm)",
                        selected = state.precipitationUnit == PrecipitationUnit.MM,
                        onClick = { onPrecipitationSelected(PrecipitationUnit.MM) }
                    )

                    UnitRow(
                        text = "Inches (in)",
                        selected = state.precipitationUnit == PrecipitationUnit.INCH,
                        onClick = { onPrecipitationSelected(PrecipitationUnit.INCH) }
                    )
                }
            }
        }
    }
}

@Composable
fun UnitRow(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .background(
                if (selected)
                    MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                else
                    Color.Transparent
            )
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = text,
            modifier = Modifier.weight(1f)
        )

        if (selected) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null
            )
        }
    }
}