package com.example.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val WeatherAppColorScheme = darkColorScheme(
    primary = Blue500,              // Used for the "Search" button
    onPrimary = Neutral0,           // Text on the "Search" button
    secondary = Orange500,          // Used for the brand logo / accents
    background = Neutral900,        // Deep blue app background
    onBackground = Neutral0,        // Primary headers ("How's the sky...")
    surface = Neutral800,           // Large containers ("Hourly forecast" section)
    onSurface = Neutral0,           // Primary text on cards
    surfaceVariant = Neutral700,    // Smaller cards ("Feels Like", "Wind")
    onSurfaceVariant = Neutral300   // Secondary text ("68°", "46%")
)

@Composable
fun WetherPrototypeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = WeatherAppColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}