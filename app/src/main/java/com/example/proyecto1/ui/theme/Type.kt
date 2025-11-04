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

val aguafinascript_regular = FontFamily(
    Font(
        R.font.aguafinascript_regular, FontWeight.Normal
    )
)

val alfaslabone_regular = FontFamily(
    Font(
        R.font.alfaslabone_regular, FontWeight.Normal
    )
)


// Default Material 3 typography values
val baseline = Typography()

val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = aguafinascript_regular),
    displayMedium = baseline.displayMedium.copy(fontFamily = aguafinascript_regular),
    displaySmall = baseline.displaySmall.copy(fontFamily = aguafinascript_regular),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = aguafinascript_regular),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = aguafinascript_regular),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = aguafinascript_regular),
    titleLarge = baseline.titleLarge.copy(fontFamily = aguafinascript_regular),
    titleMedium = baseline.titleMedium.copy(fontFamily = aguafinascript_regular),
    titleSmall = baseline.titleSmall.copy(fontFamily = aguafinascript_regular),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = aguafinascript_regular),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = aguafinascript_regular),
    bodySmall = baseline.bodySmall.copy(fontFamily = aguafinascript_regular),
    labelLarge = baseline.labelLarge.copy(fontFamily = aguafinascript_regular),
    labelMedium = baseline.labelMedium.copy(fontFamily = aguafinascript_regular),
    labelSmall = baseline.labelSmall.copy(fontFamily = aguafinascript_regular),
)

