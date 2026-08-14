package com.keystone.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    background = CanvasBackground,
    surface = SurfaceDefault,
    onSurface = TextPrimary,
    primary = PrimaryButtonFill,
    onPrimary = PrimaryButtonText,
    secondary = AccentText,
    onSecondary = SurfaceWhite,
    error = DangerText,
    onError = SurfaceWhite,
    outline = BorderDefault
)

@Composable
fun KeystoneTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        // We can add typography and shapes here later!
        content = content
    )
}