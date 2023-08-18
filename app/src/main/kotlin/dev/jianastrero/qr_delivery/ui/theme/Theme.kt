package dev.jianastrero.qr_delivery.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Primary,
    onPrimary = NeutralDark,
    secondary = Accent,
    background = NeutralDark,
    outline = BorderDark,
    scrim = BorderDark,
    error = ErrorDark,
)

private val LightColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = Neutral,
    secondary = Accent,
    background = Neutral,
    outline = Border,
    scrim = Border,
    error = Error,
)

@Composable
fun QRDeliveryAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) {
                dynamicDarkColorScheme(context).copy(
                    primary = Primary,
                    onPrimary = NeutralDark,
                    background = NeutralDark,
                    outline = BorderDark,
                    scrim = BorderDark,
                    error = ErrorDark,
                )
            } else {
                dynamicLightColorScheme(context).copy(
                    primary = Primary,
                    onPrimary = Neutral,
                    background = Neutral,
                    outline = Border,
                    scrim = Border,
                    error = Error,
                )
            }
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            // Use this if you are using a primary color that changes depending on the theme
//            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography
    ) {
        Surface(
            content = content,
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        )
    }
}
