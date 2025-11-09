package com.example.proyecto1.ui.theme


import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.Font
import com.example.proyecto1.R

val onesans_variable = FontFamily(
    Font(
        R.font.onesans_variable, FontWeight.Normal
    )
)

// Default Material 3 typography values
val baseline = Typography()

val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = onesans_variable),
    displayMedium = baseline.displayMedium.copy(fontFamily = onesans_variable),
    displaySmall = baseline.displaySmall.copy(fontFamily = onesans_variable),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = onesans_variable),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = onesans_variable),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = onesans_variable),
    titleLarge = baseline.titleLarge.copy(fontFamily = onesans_variable),
    titleMedium = baseline.titleMedium.copy(fontFamily = onesans_variable),
    titleSmall = baseline.titleSmall.copy(fontFamily = onesans_variable),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = onesans_variable),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = onesans_variable),
    bodySmall = baseline.bodySmall.copy(fontFamily = onesans_variable),
    labelLarge = baseline.labelLarge.copy(fontFamily = onesans_variable),
    labelMedium = baseline.labelMedium.copy(fontFamily = onesans_variable),
    labelSmall = baseline.labelSmall.copy(fontFamily = onesans_variable),
)

