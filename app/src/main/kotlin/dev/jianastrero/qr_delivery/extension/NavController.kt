package dev.jianastrero.qr_delivery.extension

import androidx.annotation.MainThread
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import dev.jianastrero.qr_delivery.enumeration.Screen
import dev.jianastrero.qr_delivery.type.screen.Argument
import dev.jianastrero.qr_delivery.type.screen.Parameter

@MainThread
fun NavController.navigate(
    screen: Screen,
    arguments: Map<Argument<*>, Any> = emptyMap(),
    parameters: Map<Parameter<*>, Any> = emptyMap(),
    builder: NavOptionsBuilder.() -> Unit = {}
) {
    navigate(screen.getRoute(arguments, parameters), builder)
}
