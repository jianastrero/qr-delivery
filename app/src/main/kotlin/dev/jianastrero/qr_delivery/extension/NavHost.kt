package dev.jianastrero.qr_delivery.extension

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.jianastrero.qr_delivery.enumeration.Screen

fun NavGraphBuilder.composable(
    screen: Screen,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(screen.route, content = content)
}
