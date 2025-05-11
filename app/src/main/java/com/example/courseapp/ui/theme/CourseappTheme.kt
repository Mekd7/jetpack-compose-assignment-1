package com.example.courseapp.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC5),
    surface = Color(0xFF121212),
    background = Color(0xFF121212),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onSurface = Color.White,
    onBackground = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),
    secondary = Color(0xFF03DAC5),
    surface = Color.White,
    background = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onSurface = Color.Black,
    onBackground = Color.Black
)

@Composable
fun CourseappTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}