package com.example.wetherprototype.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.wetherprototype.R


val DMSans = FontFamily(
    Font(R.font.dm_sans_light, FontWeight.Light),
    Font(R.font.dm_sans_bold, FontWeight.Bold),
    Font(R.font.dm_sans_medium, FontWeight.Medium),
    Font(R.font.dm_sans_semi_bold, FontWeight.SemiBold),
    Font(R.font.dm_sans_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic)
)

val BricolageGrotesque = FontFamily(
    Font(R.font.bricolage_grotesque_24pt_condensed_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(

    // Headings -> Bricolage Bold
    displayLarge = TextStyle(
        fontFamily = BricolageGrotesque,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,

    ),

    headlineLarge = TextStyle(
        fontFamily = BricolageGrotesque,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
    ),

    // body copy -> 18x spec
    bodyLarge = TextStyle(
        fontFamily = DMSans,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
    ),

    bodyMedium = TextStyle(
        fontFamily = DMSans,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
    ),

    labelLarge = TextStyle(
        fontFamily = DMSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
    ),
)