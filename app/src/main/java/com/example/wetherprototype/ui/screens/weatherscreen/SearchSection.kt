package com.example.wetherprototype.ui.screens.weatherscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.WeatherPrototypeTheme
import com.example.wetherprototype.domain.model.weather.Location
import com.example.wetherprototype.ui.viewmodels.WeatherSearchUiState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchSection(
    state: WeatherSearchUiState,
    onQueryChange: (String) -> Unit,
    suggestionsDelete: () -> Unit,
    onLocationClick: (Location) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    LaunchedEffect(state.suggestions) {
        expanded = state.suggestions.isNotEmpty()
    }


    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {

        TextField(
            value = state.query,
            onValueChange = {
                onQueryChange(it)
            },
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,

                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            placeholder = { Text("Search for a place...") },
            singleLine = true,
            modifier = Modifier
                .menuAnchor() // VERY IMPORTANT
                .fillMaxWidth(),
            trailingIcon = {
                if (state.query.isNotBlank()) {
                    IconButton(
                        onClick = {
                            expanded = false
                            suggestionsDelete()
                            onQueryChange("")
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close search"
                        )
                    }
                }
            }
        )

        ExposedDropdownMenu(
            expanded = if (state.suggestions.isNotEmpty()) expanded else false,
            onDismissRequest = {
                expanded = false
                focusManager.clearFocus()
            }
        ) {

            state.suggestions.forEach { location ->
                DropdownMenuItem(
                    text = {
                        Column {
                            Text(location.city)
                            Text(
                                location.country,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    },
                    onClick = {
                        expanded = false
                        suggestionsDelete()
                        onQueryChange("")
                        focusManager.clearFocus()
                        onLocationClick(location)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchSectionPreview() {
    WeatherPrototypeTheme() {
        SearchSection(
            state = WeatherSearchUiState(),
            onQueryChange = {},
            onLocationClick = {},
            suggestionsDelete = {},
            modifier = Modifier
        )
    }
}
