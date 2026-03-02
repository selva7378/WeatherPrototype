package com.example.wetherprototype.ui.screens.weatherscreen

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign


@Composable
fun HeaderSection(
    modifier: Modifier = Modifier
) {
    Text(
        text = "How's the sky looking today ?",
        style = MaterialTheme.typography.displayLarge,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

