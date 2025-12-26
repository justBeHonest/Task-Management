package com.ahmetaliasik.taskmanagement.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ahmetaliasik.taskmanagement.R

val LexendDeca = FontFamily(
    Font(R.font.lexend_deca_black, FontWeight.Black),
    Font(R.font.lexend_deca_bold, FontWeight.Bold),
    Font(R.font.lexend_deca_extra_bold, FontWeight.ExtraBold),
    Font(R.font.lexend_deca_extra_light, FontWeight.ExtraLight),
    Font(R.font.lexend_deca_light, FontWeight.Light),
    Font(R.font.lexend_deca_medium, FontWeight.Medium),
    Font(R.font.lexend_deca_regular, FontWeight.Normal),
    Font(R.font.lexend_deca_semi_bold, FontWeight.SemiBold),
    Font(R.font.lexend_deca_thin, FontWeight.Thin)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyMedium = TextStyle(
        fontFamily = LexendDeca,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
    ),

    bodyLarge = TextStyle(
        fontFamily = LexendDeca,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),


    headlineSmall = TextStyle(
        fontFamily = LexendDeca,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
    ),

    titleLarge = TextStyle(
        fontFamily = LexendDeca,
        fontWeight = FontWeight.SemiBold,
        fontSize = 19.sp,
    ),

    titleSmall = TextStyle(
        fontFamily = LexendDeca,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
    )


    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)


