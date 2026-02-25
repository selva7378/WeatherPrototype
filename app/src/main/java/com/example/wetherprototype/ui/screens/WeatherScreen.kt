package com.example.wetherprototype.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.designsystem.theme.WetherPrototypeTheme

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
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {

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